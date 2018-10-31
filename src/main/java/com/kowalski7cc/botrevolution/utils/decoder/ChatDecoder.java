package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.chat.*;
import org.json.JSONObject;

public class ChatDecoder {

    public static Chat decode(JSONObject object) {
        switch (object.getString("type")) {
            case "private":
                return decodePrivateChat(object);
            case "group":
                return decodeGroupChat(object);
            case "supergroup":
                return decodeSupergroupChat(object);
            case "channel":
                return decodeChannelChat(object);
        }
        throw new UnsupportedOperationException();
    }

    public static PrivateChat decodePrivateChat(JSONObject object) {
        return (PrivateChat) new PrivateChat(object.getLong("id"), object.getString("first_name"))
                .setLastName(object.optString("last_name"))
                .setUsername(object.optString("username"))
                .setPhoto(object.has("photo")? ChatPhotoDecoder.decode(object.getJSONObject("photo")):null);
    }

    public static GroupChat decodeGroupChat(JSONObject object) {
        return (GroupChat) new GroupChat(object.getLong("id"),
                object.getString("title"),
                object.getBoolean("all_members_are_administrators"))
                .setPhoto(object.has("photo")? ChatPhotoDecoder.decode(object.getJSONObject("photo")):null);
    }

    public static SupergroupChat decodeSupergroupChat(JSONObject object) {
        return (SupergroupChat) new SupergroupChat(object.getLong("id"), object.getString("title"))
                .setDescription(object.optString("description"))
                .setInviteLink(object.optString("invite_link"))
                .setPinnedMessage(object.has("pinned_message")?
                        MessageDecoder.decode(object.getJSONObject("pinned_message")):null)
                .setUsername(object.optString("username"))
                .setStickerSetName(object.optString("sticker_set_name"))
                .setCanSetStickerSet(object.optBoolean("can_set_sticker_set"))
                .setPhoto(object.has("photo")? ChatPhotoDecoder.decode(object.getJSONObject("photo")):null);
    }

    public static ChannelChat decodeChannelChat(JSONObject object) {
        return (ChannelChat) new ChannelChat(object.getLong("id"), object.getString("title"))
                .setDescription(object.optString("description"))
                .setInviteLink(object.optString("invite_link"))
                .setPinnedMessage(object.has("pinned_message")?
                        MessageDecoder.decode(object.getJSONObject("pinned_message")):null)
                .setUsername(object.optString("username"))
                .setPhoto(object.has("photo")? ChatPhotoDecoder.decode(object.getJSONObject("photo")):null);
    }
}
