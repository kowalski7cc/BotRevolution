package com.kowalski7cc.botrevolution;

import com.kowalski7cc.botrevolution.actions.*;
import com.kowalski7cc.botrevolution.receivers.PollingReceiver;
import com.kowalski7cc.botrevolution.types.Update;
import com.kowalski7cc.botrevolution.types.User;
import com.kowalski7cc.botrevolution.types.WebhookInfo;
import com.kowalski7cc.botrevolution.types.media.FileAttachment;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.*;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;

public class TelegramBot {

    private String token;
    private PollingReceiver receiver;
    private final static int DEFAULT_TIMEOUT = 20;
    private Integer timeout;

    public TelegramBot(String token) {
        this.token = Objects.requireNonNull(token);
        this.receiver = new PollingReceiver(token);
    }

    public Optional<Integer> getTimeout() {
        return Optional.ofNullable(timeout);
    }

    public TelegramBot setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    public PollingReceiver getReceiver() {
        return receiver;
    }

    public Queue<Update> getUpdates() {
        return receiver.getUpdates();
    }

    private int getProgrammedTimeout() {
        if (timeout==null)
            return DEFAULT_TIMEOUT;
        return timeout;
    }

    // TELEGRAM METHODS

    public SetWebhook setWebhook() {return new SetWebhook(token, getProgrammedTimeout());}

    public Optional<Boolean> deleteWebhook() {
        return RequestHelper.get(token, BotMethod.DELETEWEBHOOK, null, getProgrammedTimeout())
                .map(object -> ResponseDecoder.decodeBoolean(object));
    }

    public Optional<WebhookInfo> getWebhookInfo() {
        return RequestHelper.get(token, BotMethod.GETWEBHOOKINFO, null, getProgrammedTimeout())
                .map(object -> WebhookInfoDecoder.decode(ResponseDecoder.decode(object)));
    }

    public Optional<User> getMe() {
        return RequestHelper.get(token, BotMethod.GETME, null, getProgrammedTimeout())
                .map(object -> UserDecoder.decode(ResponseDecoder.decode(object)));
    }

    // BUILDER METHODS

    public SendMessage sendMessage() {
        return new SendMessage(token, getProgrammedTimeout());
    }

    public ForwardMessage forwardMessage() {
        return new ForwardMessage(token, getProgrammedTimeout());
    }

    public SendPhoto sendPhoto() {
        return new SendPhoto(token, getProgrammedTimeout());
    }

    public SendAudio sendAudio () { return new SendAudio(token, getProgrammedTimeout()); }

    public SendDocument sendDocument() {return new SendDocument(token, getProgrammedTimeout());}

    public SendVideo sendVideo() {
        return new SendVideo(token, getProgrammedTimeout());
    }

    public SendAnimation sendAnimation() { return new SendAnimation(token, getProgrammedTimeout());}

    public SendVoice sendVoice() {return new SendVoice(token, getProgrammedTimeout());}

    public SendVideoNote sendVideoNote() {return  new SendVideoNote(token, getProgrammedTimeout());}

    // TODO ADD MISSING SEND MEDIA GROUP.

    public SendLocation sendLocation(){
        return new SendLocation(token, getProgrammedTimeout());
    }

    public EditMessageLiveLocation editMessageLiveLocation() {
        return new EditMessageLiveLocation(token, getProgrammedTimeout());
    }

    public StopMessageLiveLocation stopMessageLiveLocation() {
        return new StopMessageLiveLocation(token, getProgrammedTimeout());
    }

    public SendVenue sendVenue() {
        return new SendVenue(token, getProgrammedTimeout());
    }

    public SendContact sendContact() {
        return new SendContact(token, getProgrammedTimeout());
    }

    public SendChatAction sendChatAction() {
        return new SendChatAction(token, getProgrammedTimeout());
    }

    public GetUserProfilePhotos getUserProfilePhotos() {
        return new GetUserProfilePhotos(token, getProgrammedTimeout());
    }

    public Optional<FileAttachment> getFile(String fileID) {
        try {
            return Optional.of(RequestHelper.getFile(fileID, token, timeout));
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public KickChatMember kickChatMember() {
        return new KickChatMember(token, getProgrammedTimeout());
    }

    public UnbanChatMember unbanChatMember() {
        return new UnbanChatMember(token, getProgrammedTimeout());
    }

    public RestrictChatMember restrictChatMember() {
        return new RestrictChatMember(token, getProgrammedTimeout());
    }

    public PromoteChatMember promoteChatMember() {
        return new PromoteChatMember(token, getProgrammedTimeout());
    }

    public ExportChatInviteLink exportChatInviteLink() {
        return new ExportChatInviteLink(token, getProgrammedTimeout());
    }

    public SetChatPhoto setChatPhoto() {
        return new SetChatPhoto(token, getProgrammedTimeout());
    }

    public DeleteChatPhoto deleteChatPhoto() {
        return new DeleteChatPhoto(token, getProgrammedTimeout());
    }

    public SetChatTitle setChatTitle() {
        return new SetChatTitle(token, getProgrammedTimeout());
    }

    public SetChatDescription setChatDescription() {
        return new SetChatDescription(token, getProgrammedTimeout());
    }

    public PinChatMessage pinChatMessage() {
        return new PinChatMessage(token, getProgrammedTimeout());
    }

    public UnpinChatMessage unpinChatMessage() {
        return new UnpinChatMessage(token, getProgrammedTimeout());
    }

    public LeaveChat leaveChat() {
        return new LeaveChat(token, getProgrammedTimeout());
    }

    public GetChat getChat() {
        return new GetChat(token, getProgrammedTimeout());
    }

    public GetChatAdministrators getChatAdministrators() {return new GetChatAdministrators(token, getProgrammedTimeout());}

    public GetChatMembersCount getChatMembersCount() {return new GetChatMembersCount(token, getProgrammedTimeout());}

    public GetChatMember getChatMember() {return new GetChatMember(token, getProgrammedTimeout());}

    public SetChatStickerSet setChatStickerSet() {return new SetChatStickerSet(token, getProgrammedTimeout());}

    public DeleteChatStickerSet deleteChatStickerSet() {return new DeleteChatStickerSet(token, getProgrammedTimeout());}

    // TODO Add here answerCallbackQuery()

    // UPDATING MESSAGES

    public EditMessageText editMessageText() {return new EditMessageText(token, getProgrammedTimeout());}

    public EditMessageCaption editMessageCaption() {return new EditMessageCaption(token, getProgrammedTimeout());}

    // TODO Add here editMessageMedia()

    public EditMessageReplyMarkup editMessageReplyMarkup() {return new EditMessageReplyMarkup(token, getProgrammedTimeout());}

    public DeleteMessage deleteMessage() {return new DeleteMessage(token, getProgrammedTimeout());}

    // STICKERS

    public SendSticker sendSticker() {return new SendSticker(token, getProgrammedTimeout());}

    public GetStickerSet getStickerSet() {return new GetStickerSet(token, getProgrammedTimeout());}

    public UploadStickerFile uploadStickerFile() {return new UploadStickerFile(token, getProgrammedTimeout());}

    public CreateNewStickerSet createNewStickerSet() {return new CreateNewStickerSet(token, getProgrammedTimeout());}

    public AddStickerToSet addStickerToSet() {return new AddStickerToSet(token, getProgrammedTimeout());}

    public SetStickerPositionInSet setStickerPositionInSet() {return new SetStickerPositionInSet(token, getProgrammedTimeout());}

    public DeleteStickerFromSet deleteStickerFromSet() {return new DeleteStickerFromSet(token, getProgrammedTimeout());}

    // INLINE MODE

    // TODO Add inline mode

    // PAYMENTS

    public SendInvoice sendInvoice() {return new SendInvoice(token, getProgrammedTimeout());}

    public AnswerShippingQuery answerShippingQuery() {return new AnswerShippingQuery(token, getProgrammedTimeout());}

    public AnswerPreCheckoutQuery answerPreCheckoutQuery() {return new AnswerPreCheckoutQuery(token, getProgrammedTimeout());}

    // GAMES

    public SendGame sendGame() {return new SendGame(token, getProgrammedTimeout());}

    public SetGameScore setGameScore() {return new SetGameScore(token, getProgrammedTimeout());}

    public GetGameHighScores getGameHighScores() {return new GetGameHighScores(token, getProgrammedTimeout());}

    // SERVICE CODE

    public void downloadFile(FileAttachment origin, File destination) throws IOException {
        RequestHelper.downloadFile(origin, destination, token, getProgrammedTimeout());
    }

}
