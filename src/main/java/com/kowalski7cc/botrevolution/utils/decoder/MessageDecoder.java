package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.Message;
import org.json.JSONObject;

import java.util.Optional;

public class MessageDecoder {

    public static Message decode(JSONObject object) {
        return new Message(object.getInt("message_id"), object.getInt("date"),
                ChatDecoder.decode(object.getJSONObject("chat"))).setFrom(
                        Optional.ofNullable(object.optJSONObject("from")).map(UserDecoder::decode).orElse(null))
                        .setForwardFrom(Optional.ofNullable(object.optJSONObject("forward_from"))
                                .map(UserDecoder::decode).orElse(null))
                        .setForwardFromChat(Optional.ofNullable(object.optJSONObject("forward_from_chat"))
                                .map(ChatDecoder::decode).orElse(null))
                        .setForwardFromMessageID(getInteger(object.optInt("forward_from_message_id")))

                        // TODO This is really an ugly part
                        .setForwardSignature(object.optString("forward_signature", null))
                        .setForwardDate(getInteger(object.optInt("forward_date")))
                        .setReplyToMessage(
                                object.has("reply_to_message") ? decode(object.getJSONObject("reply_to_message"))
                                        : null)
                        .setEditDate(getInteger(object.optInt("edit_date")))
                        .setMediaGroupID(object.optString("media_group_id", null))
                        .setAuthorSignature(object.optString("author_signature", null))
                        .setText(object.optString("text", null))
                        .setEntities(object.has("entities")
                                ? MessageEntityDecoder.decodeArray(object.getJSONArray("entities"))
                                : null)
                        .setCaptionEntities(object.has("caption_entities")
                                ? MessageEntityDecoder.decodeArray(object.getJSONArray("caption_entities"))
                                : null)
                        .setAudio(object.has("audio") ? AudioDecoder.decode(object.getJSONObject("audio")) : null)
                        .setDocument(object.has("document") ? DocumentDecoder.decode(object.getJSONObject("document"))
                                : null)
                        .setAnimation(
                                object.has("animation") ? AnimationDecoder.decode(object.getJSONObject("animation"))
                                        : null)
                        .setGame(object.has("game") ? GameDecoder.decode(object.getJSONObject("game")) : null)
                        .setPhoto(
                                object.has("photo") ? PhotoSizeDecoder.decodeArray(object.getJSONArray("photo")) : null)
                        .setSticker(
                                object.has("sticker") ? StickerDecoder.decode(object.getJSONObject("sticker")) : null)
                        .setVideo(object.has("video") ? VideoDecoder.decode(object.getJSONObject("video")) : null)
                        .setVoice(object.has("voice") ? VoiceDecoder.decode(object.getJSONObject("voice")) : null)
                        .setVideoNote(
                                object.has("video_note") ? VideoNoteDecoder.decode(object.getJSONObject("video_note"))
                                        : null)
                        .setCaption(object.optString("caption", null))
                        .setContact(
                                object.has("contact") ? ContactDecoder.decode(object.getJSONObject("contact")) : null)
                        .setLocation(object.has("location") ? LocationDecoder.decode(object.getJSONObject("location"))
                                : null)
                        .setVenue(object.has("venue") ? VenueDecoder.decode(object.getJSONObject("venue")) : null)
                        .setNewChatMembers(object.has("new_chat_members")
                                ? UserDecoder.decodeArray(object.getJSONArray("new_chat_members"))
                                : null)
                        .setLeftChatMember(object.has("left_chat_member")
                                ? UserDecoder.decode(object.getJSONObject("left_chat_member"))
                                : null)
                        .setNewChatTitle(object.optString("new_chat_title", null))
                        .setNewChatPhoto(object.has("new_chat_photo")
                                ? PhotoSizeDecoder.decodeArray(object.getJSONArray("new_chat_photo"))
                                : null)
                        .setDeleteChatPhoto(object.optBoolean("delete_chat_photo"))
                        .setGroupChatCreated(object.optBoolean("group_chat_created"))
                        .setSupergroupChatCreated(object.optBoolean("supergroup_chat_created"))
                        .setChannelChatCreated(object.optBoolean("channel_chat_created"))
                        .setMigrateToChatID(getInteger(object.optInt("migrate_to_chat_id")))
                        .setMigrateFromChatID(getInteger(object.optInt("migrate_from_chat_id")))
                        .setPinnedMessage(
                                object.has("pinned_message") ? decode(object.getJSONObject("pinned_message")) : null)
                        .setInvoice(
                                object.has("invoice") ? InvoiceDecoder.decode(object.getJSONObject("invoice")) : null)
                        .setSuccessfulPayment(object.has("successful_payment")
                                ? SuccessfulPaymentDecoder.decode(object.getJSONObject("successful_payment"))
                                : null)
                        .setConnectedWebsite(object.optString("connected_website", null));
    }

    private static Integer getInteger(Integer integer) {
        return integer == 0 ? null : integer;
    }
}
