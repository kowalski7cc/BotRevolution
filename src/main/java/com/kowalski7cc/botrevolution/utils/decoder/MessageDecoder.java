package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.Message;
import org.json.JSONObject;

public class MessageDecoder {

    public static Message decode(JSONObject object) {
        return new Message(object.getInt("message_id"),
                object.getInt("date"),
                ChatDecoder.decode(object.getJSONObject("chat")))
                .setFrom(object.has("from")? UserDecoder.decode(object.getJSONObject("from")):null)
                .setForwardFrom(object.has("forward_from")?UserDecoder.decode(object.getJSONObject("forward_from")):null)
                .setForwardFromChat(object.has("forward_from_chat")?ChatDecoder.decode(object.getJSONObject("forward_from_chat")):null)
                .setForwardFromMessageID(object.optInt("forward_from_message_id"))
                .setForwardSignature(object.optString("forward_signature"))
                .setForwardDate(object.optInt("forward_date"))
                .setReplyToMessage(object.has("reply_to_message")?decode(object.getJSONObject("reply_to_message")):null)
                .setEditDate(object.optInt("edit_date"))
                .setMediaGroupID(object.optString("media_group_id"))
                .setAuthorSignature(object.optString("author_signature"))
                .setText(object.optString("text"))
                .setEntities(object.has("entities")?MessageEntityDecoder.decodeArray(object.getJSONArray("entities")):null)
                .setCaptionEntities(object.has("caption_entities")?MessageEntityDecoder.decodeArray(object.getJSONArray("caption_entities")):null)
                .setAudio(object.has("audio")?AudioDecoder.decode(object.getJSONObject("audio")):null)
                .setDocument(object.has("document")?DocumentDecoder.decode(object.getJSONObject("document")):null)
                .setAnimation(object.has("animation")?AnimationDecoder.decode(object.getJSONObject("animation")):null)
                .setGame(object.has("game")?GameDecoder.decode(object.getJSONObject("game")):null)
                .setPhoto(object.has("photo")?PhotoSizeDecoder.decodeArray(object.getJSONArray("photo")):null)
                .setSticker(object.has("sticker")?StickerDecoder.decode(object.getJSONObject("sticker")):null)
                .setVideo(object.has("video")?VideoDecoder.decode(object.getJSONObject("video")):null)
                .setVoice(object.has("voice")?VoiceDecoder.decode(object.getJSONObject("voice")):null)
                .setVideoNote(object.has("video_note")?VideoNoteDecoder.decode(object.getJSONObject("video_note")):null)
                .setCaption(object.optString("caption"))
                .setContact(object.has("contact")? ContactDecoder.decode(object.getJSONObject("contact")):null)
                .setLocation(object.has("location")? LocationDecoder.decode(object.getJSONObject("location")):null)
                .setVenue(object.has("venue")? VenueDecoder.decode(object.getJSONObject("venue")):null)
                .setNewChatMembers(object.has("new_chat_members")?UserDecoder.decodeArray(object.getJSONArray("new_chat_members")):null)
                .setLeftChatMember(object.has("left_chat_member")? UserDecoder.decode(object.getJSONObject("left_chat_member")):null)
                .setNewChatTitle(object.optString("new_chat_title"))
                .setNewChatPhoto(object.has("new_chat_photo")?PhotoSizeDecoder.decodeArray(object.getJSONArray("new_chat_photo")):null)
                .setDeleteChatPhoto(object.optBoolean("delete_chat_photo"))
                .setGroupChatCreated(object.optBoolean("group_chat_created"))
                .setSupergroupChatCreated(object.optBoolean("supergroup_chat_created"))
                .setChannelChatCreated(object.optBoolean("channel_chat_created"))
                .setMigrateToChatID(object.optInt("migrate_to_chat_id"))
                .setMigrateFromChatID(object.optInt("migrate_from_chat_id"))
                .setPinnedMessage(object.has("pinned_message")?decode(object.getJSONObject("pinned_message")):null)
                .setInvoice(object.has("invoice")?InvoiceDecoder.decode(object.getJSONObject("invoice")):null)
                .setSuccessfulPayment(object.has("successful_payment")?SuccessfulPaymentDecoder.decode(object.getJSONObject("successful_payment")):null)
                .setConnectedWebsite(object.optString("connected_website"));
    }
}
