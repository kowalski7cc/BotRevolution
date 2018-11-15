package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.chat.ChatMember;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class ChatMemberDecoder {

    public static List<ChatMember> decodeArray(JSONArray array) {
        var list = new LinkedList<ChatMember>();
        array.forEach(o -> list.add(decode((JSONObject) o)));
        return list;
    }

    public static ChatMember decode(JSONObject object) {
        return new ChatMember(UserDecoder.decode(object.getJSONObject("user")), object.getString("status")).setUntilDate(object.optInt("until_date"))
                .setCanBeEdited(object.optBoolean("can_be_edited"))
                .setCanChangeInfo(object.optBoolean("can_change_info"))
                .setCanPostMessages(object.optBoolean("can_post_messages"))
                .setCanEditMessages(object.optBoolean("can_edit_messages"))
                .setCanDeleteMessages(object.optBoolean("can_delete_messages"))
                .setCanInviteUsers(object.optBoolean("can_invite_users"))
                .setCanRestrictMembers(object.optBoolean("can_restrict_members"))
                .setCanPinMessages(object.optBoolean("can_pin_messages"))
                .setCanPromoteMembers(object.optBoolean("can_promote_members"))
                .setCanSendMessages(object.optBoolean("can_send_messages"))
                .setCanSendMediaMessages(object.optBoolean("can_send_media_messages"))
                .setCanSendOtherMessages(object.optBoolean("can_send_other_messages"))
                .setCanAddWebPagePreviews(object.optBoolean("can_add_web_page_previews"));
    }
}
