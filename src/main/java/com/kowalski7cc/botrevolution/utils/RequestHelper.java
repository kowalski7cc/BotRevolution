package com.kowalski7cc.botrevolution.utils;

import com.kowalski7cc.botrevolution.types.media.FileAttachment;
import com.kowalski7cc.botrevolution.utils.decoder.FileAttachmentDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.TelegramException;
import okhttp3.*;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class RequestHelper {

    private static final String BASE_URL = "https://api.telegram.org/bot";
    private final static String FILE_DOWNLOAD_PATH = "https://api.telegram.org/file/bot";

    public static Optional<JSONObject> get(String token, BotMethod method, Map<String, String> parameters, int timeout) {
        try {
            return Optional.of(new JSONObject(makeRequest(buildUrl(token, method, parameters), timeout)));
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public static String buildUrl(String token, BotMethod method, Map<String, String> parameters) {
        StringBuilder stringBuilder = new StringBuilder(BASE_URL);
        stringBuilder.append(Objects.requireNonNull(token));
        stringBuilder.append("/");
        stringBuilder.append(Objects.requireNonNull(method));
        if (parameters != null && !parameters.isEmpty()) {
            stringBuilder.append("?");
            Iterator<Map.Entry<String, String>> entries = parameters.entrySet().iterator();
            Map.Entry<String, String> entry = entries.next();
            stringBuilder.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            while (entries.hasNext()) {
                stringBuilder.append("&");
                entry = entries.next();
                stringBuilder.append(entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            }
        }
        return stringBuilder.toString();
    }

    public static JSONObject postMedia(String url, Map<String, Object> payload, int timeout) throws IOException {
        return new JSONObject(postRequest(url, payload, timeout));
    }

    public static String postRequest(String url, Map<String, Object> payload, int timeout) throws IOException {
        var client = new OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .build();

        MultipartBody.Builder requestBodyBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);

        payload.forEach((key, load) -> {
            if(load instanceof String) {
                requestBodyBuilder.addFormDataPart(key, (String) load);
            } else if (load instanceof File) {
                try {
                    requestBodyBuilder.addFormDataPart(key, ((File) load).getName(),
                            RequestBody.create(MediaType.parse(Files.probeContentType(((File) load).toPath())), (File) load));
                } catch (IOException e) {
                    requestBodyBuilder.addFormDataPart(key, ((File) load).getName(),
                            RequestBody.create(MediaType.parse("application/binary"), (File) load));
                }
            }
        });
        RequestBody requestBody = requestBodyBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return getResponse(request, client);
    }

    public static String makeRequest(String request, int timeout) throws IOException {
        Request httpRequest = new Request.Builder().url(Objects.requireNonNull(request)).build();
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .build();
        return getResponse(httpRequest, client);
    }

    @SuppressWarnings("ConstantConditions")
    private static String getResponse(Request httpRequest, OkHttpClient client) throws IOException {
        Response response = client.newCall(httpRequest).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new TelegramException(new JSONObject(response.body().string()));
        }
    }

    public static void downloadFile(FileAttachment origin, File destination, String token, int timeout) throws IOException {
        if (!origin.getFilePath().isPresent()) {
            origin = getFile(origin.getFileID(), token, timeout);
        }
        StringBuilder stringBuilder = new StringBuilder(FILE_DOWNLOAD_PATH);
        stringBuilder.append(token);
        stringBuilder.append("/");
        stringBuilder.append(origin.getFilePath());
        try {
            FileUtils.copyURLToFile(new URL(stringBuilder.toString()), Objects.requireNonNull(destination));
        } catch (MalformedURLException e) {
            throw new IOException(e);
        }
    }

    public static FileAttachment getFile(String fileID, String token, int timeout) throws IOException {
        Objects.requireNonNull(fileID);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("file_id", fileID);
        String request = buildUrl(token, BotMethod.GETFILE, parameters);
        String response = makeRequest(request, timeout);
        return FileAttachmentDecoder.decode(ResponseDecoder.decode(new JSONObject(response)));
    }

}
