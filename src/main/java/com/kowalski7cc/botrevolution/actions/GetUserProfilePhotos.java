package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.User;
import com.kowalski7cc.botrevolution.types.UserProfilePhotos;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.UserProfilePhotosDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class GetUserProfilePhotos extends MethodBuilder<UserProfilePhotos> {

    private Integer userID;
    private Integer offset;
    private Integer limit;

    public GetUserProfilePhotos(String token, Integer timeout) {
        super(token, timeout);
    }

    public GetUserProfilePhotos setUserID(User user) {
        this.userID = user.getId();
        return this;
    }

    public GetUserProfilePhotos setUserID(Integer userID) {
        this.userID = userID;
        return this;
    }

    public GetUserProfilePhotos setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public GetUserProfilePhotos setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public Optional<UserProfilePhotos> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("user_id", Objects.requireNonNull(userID.toString()));
        if (offset != null)
            parameters.put("offset", offset.toString());
        if (limit != null)
            parameters.put("limit", limit.toString());
        return RequestHelper.get(token, BotMethod.SENDVENUE, parameters, timeout)
                .map(object -> UserProfilePhotosDecoder.decode(ResponseDecoder.decode(object)));
    }
}
