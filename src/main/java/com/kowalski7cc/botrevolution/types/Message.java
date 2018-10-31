package com.kowalski7cc.botrevolution.types;

import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.types.games.Game;
import com.kowalski7cc.botrevolution.types.media.*;
import com.kowalski7cc.botrevolution.types.payments.Invoice;
import com.kowalski7cc.botrevolution.types.payments.SuccessfulPayment;
import com.kowalski7cc.botrevolution.types.stickers.Sticker;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Message {
    private Integer messageID;
    private User from;
    private Integer date;
    private Chat chat;
    private User forwardFrom;
    private Chat forwardFromChat;
    private Integer forwardFromMessageID;
    private String forwardSignature;
    private Integer forwardDate;
    private Message replyToMessage;
    private Integer editDate;
    private String mediaGroupID;
    private String authorSignature;
    private String text;
    private List<MessageEntity> entities;
    private List<MessageEntity> captionEntities;
    private Audio audio;
    private Document document;
    private Animation animation;
    private Game game;
    private List<PhotoSize> photo;
    private Sticker sticker;
    private Video video;
    private Voice voice;
    private VideoNote videoNote;
    private String caption;
    private Contact contact;
    private Location location;
    private Venue venue;
    private List<User> newChatMembers;
    private User leftChatMember;
    private String newChatTitle;
    private List<PhotoSize> newChatPhoto;
    private Boolean deleteChatPhoto;
    private Boolean groupChatCreated;
    private Boolean supergroupChatCreated;
    private Boolean channelChatCreated;
    private Integer migrateToChatID;
    private Integer migrateFromChatID;
    private Message pinnedMessage;
    private Invoice invoice;
    private SuccessfulPayment successfulPayment;
    private String connectedWebsite;

    public Message(Integer messageID, Integer date, Chat chat) {
        this.messageID = messageID;
        this.date = date;
        this.chat = chat;
    }

    public Integer getMessageID() {
        return messageID;
    }

    public Message setMessageID(Integer messageID) {
        this.messageID = Objects.requireNonNull(messageID);
        return this;
    }

    public Integer getDate() {
        return date;
    }

    public Message setDate(Integer date) {
        this.date = Objects.requireNonNull(date);
        return this;
    }

    public Chat getChat() {
        return chat;
    }

    public Message setChat(Chat chat) {
        this.chat = Objects.requireNonNull(chat);
        return this;
    }

    public Optional<User> getFrom() {
        return Optional.ofNullable(from);
    }

    public Message setFrom(User from) {
        this.from = from;
        return this;
    }

    public Optional<User> getForwardFrom() {
        return Optional.ofNullable(forwardFrom);
    }

    public Message setForwardFrom(User forwardFrom) {
        this.forwardFrom = forwardFrom;
        return this;
    }

    public Optional<Chat> getForwardFromChat() {
        return Optional.ofNullable(forwardFromChat);
    }

    public Message setForwardFromChat(Chat forwardFromChat) {
        this.forwardFromChat = forwardFromChat;
        return this;
    }

    public Optional<Integer> getForwardFromMessageID() {
        return Optional.ofNullable(forwardFromMessageID);
    }

    public Message setForwardFromMessageID(Integer forwardFromMessageID) {
        this.forwardFromMessageID = forwardFromMessageID;
        return this;
    }

    public Optional<String> getForwardSignature() {
        return Optional.ofNullable(forwardSignature);
    }

    public Message setForwardSignature(String forwardSignature) {
        this.forwardSignature = forwardSignature;
        return this;
    }

    public Optional<Integer> getForwardDate() {
        return Optional.ofNullable(forwardDate);
    }

    public Message setForwardDate(Integer forwardDate) {
        this.forwardDate = forwardDate;
        return this;
    }

    public Optional<Message> getReplyToMessage() {
        return Optional.ofNullable(replyToMessage);
    }

    public Message setReplyToMessage(Message replyToMessage) {
        this.replyToMessage = replyToMessage;
        return this;
    }

    public Optional<Integer> getEditDate() {
        return Optional.ofNullable(editDate);
    }

    public Message setEditDate(Integer editDate) {
        this.editDate = editDate;
        return this;
    }

    public Optional<String> getMediaGroupID() {
        return Optional.ofNullable(mediaGroupID);
    }

    public Message setMediaGroupID(String mediaGroupID) {
        this.mediaGroupID = mediaGroupID;
        return this;
    }

    public Optional<String> getAuthorSignature() {
        return Optional.ofNullable(authorSignature);
    }

    public Message setAuthorSignature(String authorSignature) {
        this.authorSignature = authorSignature;
        return this;
    }

    public Optional<String> getText() {
        return Optional.ofNullable(text);
    }

    public Message setText(String text) {
        this.text = text;
        return this;
    }

    public Optional<List<MessageEntity>> getEntities() {
        return Optional.ofNullable(entities);
    }

    public Message setEntities(List<MessageEntity> entities) {
        this.entities = entities;
        return this;
    }

    public Optional<List<MessageEntity>> getCaptionEntities() {
        return Optional.ofNullable(captionEntities);
    }

    public Message setCaptionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    public Optional<Audio> getAudio() {
        return Optional.ofNullable(audio);
    }

    public Message setAudio(Audio audio) {
        this.audio = audio;
        return this;
    }

    public Optional<Document> getDocument() {
        return Optional.ofNullable(document);
    }

    public Message setDocument(Document document) {
        this.document = document;
        return this;
    }

    public Optional<Animation> getAnimation() {
        return Optional.ofNullable(animation);
    }

    public Message setAnimation(Animation animation) {
        this.animation = animation;
        return this;
    }

    public Optional<Game> getGame() {
        return Optional.ofNullable(game);
    }

    public Message setGame(Game game) {
        this.game = game;
        return this;
    }

    public Optional<List<PhotoSize>> getPhoto() {
        return Optional.ofNullable(photo);
    }

    public Message setPhoto(List<PhotoSize> photo) {
        this.photo = photo;
        return this;
    }

    public Optional<Sticker> getSticker() {
        return Optional.ofNullable(sticker);
    }

    public Message setSticker(Sticker sticker) {
        this.sticker = sticker;
        return this;
    }

    public Optional<Video> getVideo() {
        return Optional.ofNullable(video);
    }

    public Message setVideo(Video video) {
        this.video = video;
        return this;
    }

    public Optional<String> getCaption() {
        return Optional.ofNullable(caption);
    }

    public Message setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public Optional<Contact> getContact() {
        return Optional.ofNullable(contact);
    }

    public Message setContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    public Optional<Location> getLocation() {
        return Optional.ofNullable(location);
    }

    public Message setLocation(Location location) {
        this.location = location;
        return this;
    }

    public Optional<Venue> getVenue() {
        return Optional.ofNullable(venue);
    }

    public Message setVenue(Venue venue) {
        this.venue = venue;
        return this;
    }

    public Optional<List<User>> getNewChatMembers() {
        return Optional.ofNullable(newChatMembers);
    }

    public Message setNewChatMembers(List<User> newChatMembers) {
        this.newChatMembers = newChatMembers;
        return this;
    }

    public Optional<User> getLeftChatMember() {
        return Optional.ofNullable(leftChatMember);
    }

    public Message setLeftChatMember(User leftChatMember) {
        this.leftChatMember = leftChatMember;
        return this;
    }

    public Optional<String> getNewChatTitle() {
        return Optional.ofNullable(newChatTitle);
    }

    public Message setNewChatTitle(String newChatTitle) {
        this.newChatTitle = newChatTitle;
        return this;
    }

    public Optional<List<PhotoSize>> getNewChatPhoto() {
        return Optional.ofNullable(newChatPhoto);
    }

    public Message setNewChatPhoto(List<PhotoSize> newChatPhoto) {
        this.newChatPhoto = newChatPhoto;
        return this;
    }

    public Optional<Boolean> getDeleteChatPhoto() {
        return Optional.ofNullable(deleteChatPhoto);
    }

    public Message setDeleteChatPhoto(Boolean deleteChatPhoto) {
        this.deleteChatPhoto = deleteChatPhoto;
        return this;
    }

    public Optional<Boolean> getGroupChatCreated() {
        return Optional.ofNullable(groupChatCreated);
    }

    public Message setGroupChatCreated(Boolean groupChatCreated) {
        this.groupChatCreated = groupChatCreated;
        return this;
    }

    public Optional<Boolean> getSupergroupChatCreated() {
        return Optional.ofNullable(supergroupChatCreated);
    }

    public Message setSupergroupChatCreated(Boolean supergroupChatCreated) {
        this.supergroupChatCreated = supergroupChatCreated;
        return this;
    }

    public Optional<Boolean> getChannelChatCreated() {
        return Optional.ofNullable(channelChatCreated);
    }

    public Message setChannelChatCreated(Boolean channelChatCreated) {
        this.channelChatCreated = channelChatCreated;
        return this;
    }

    public Optional<Integer> getMigrateToChatID() {
        return Optional.ofNullable(migrateToChatID);
    }

    public Message setMigrateToChatID(Integer migrateToChatID) {
        this.migrateToChatID = migrateToChatID;
        return this;
    }

    public Optional<Integer> getMigrateFromChatID() {
        return Optional.ofNullable(migrateFromChatID);
    }

    public Message setMigrateFromChatID(Integer migrateFromChatID) {
        this.migrateFromChatID = migrateFromChatID;
        return this;
    }

    public Optional<Message> getPinnedMessage() {
        return Optional.ofNullable(pinnedMessage);
    }

    public Message setPinnedMessage(Message pinnedMessage) {
        this.pinnedMessage = pinnedMessage;
        return this;
    }

    public Optional<Invoice> getInvoice() {
        return Optional.ofNullable(invoice);
    }

    public Message setInvoice(Invoice invoice) {
        this.invoice = invoice;
        return this;
    }

    public Optional<SuccessfulPayment> getSuccessfulPayment() {
        return Optional.ofNullable(successfulPayment);
    }

    public Message setSuccessfulPayment(SuccessfulPayment successfulPayment) {
        this.successfulPayment = successfulPayment;
        return this;
    }

    public Optional<String> getConnectedWebsite() {
        return Optional.ofNullable(connectedWebsite);
    }

    public Message setConnectedWebsite(String connectedWebsite) {
        this.connectedWebsite = connectedWebsite;
        return this;
    }

    public Optional<Voice> getVoice() {
        return Optional.ofNullable(voice);
    }

    public Message setVoice(Voice voice) {
        this.voice = voice;
        return this;
    }

    public Optional<VideoNote> getVideoNote() {
        return Optional.ofNullable(videoNote);
    }

    public Message setVideoNote(VideoNote videoNote) {
        this.videoNote = videoNote;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return messageID.equals(message.messageID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageID);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageID=" + messageID +
                ", from=" + from +
                ", date=" + date +
                ", chat=" + chat +
                ", forwardFrom=" + forwardFrom +
                ", forwardFromChat=" + forwardFromChat +
                ", forwardFromMessageID=" + forwardFromMessageID +
                ", forwardSignature='" + forwardSignature + '\'' +
                ", forwardDate=" + forwardDate +
                ", replyToMessage=" + replyToMessage +
                ", editDate=" + editDate +
                ", mediaGroupID='" + mediaGroupID + '\'' +
                ", authorSignature='" + authorSignature + '\'' +
                ", text='" + text + '\'' +
                ", entities=" + entities +
                ", captionEntities=" + captionEntities +
                ", audio=" + audio +
                ", document=" + document +
                ", animation=" + animation +
                ", game=" + game +
                ", photo=" + photo +
                ", sticker=" + sticker +
                ", video=" + video +
                ", caption='" + caption + '\'' +
                ", contact=" + contact +
                ", location=" + location +
                ", venue=" + venue +
                ", newChatMembers=" + newChatMembers +
                ", leftChatMember=" + leftChatMember +
                ", newChatTitle='" + newChatTitle + '\'' +
                ", newChatPhoto=" + newChatPhoto +
                ", deleteChatPhoto=" + deleteChatPhoto +
                ", groupChatCreated=" + groupChatCreated +
                ", supergroupChatCreated=" + supergroupChatCreated +
                ", channelChatCreated=" + channelChatCreated +
                ", migrateToChatID=" + migrateToChatID +
                ", migrateFromChatID=" + migrateFromChatID +
                ", pinnedMessage=" + pinnedMessage +
                ", invoice=" + invoice +
                ", successfulPayment=" + successfulPayment +
                ", connectedWebsite='" + connectedWebsite + '\'' +
                '}';
    }
}
