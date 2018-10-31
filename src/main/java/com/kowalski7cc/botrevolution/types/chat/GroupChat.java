package com.kowalski7cc.botrevolution.types.chat;

import java.util.Objects;

public class GroupChat extends Chat {

    private String title;
    private Boolean allMembersAreAdminitrators;

    public GroupChat(Long id, String title, Boolean allMembersAreAdminitrators) {
        super(id);
        this.title = Objects.requireNonNull(title);
        this.allMembersAreAdminitrators = Objects.requireNonNull(allMembersAreAdminitrators);
    }

    @Override
    public ChatType getType() {
        return ChatType.GROUP;
    }

    public String getTitle() {
        return title;
    }

    public GroupChat setTitle(String title) {
        this.title = Objects.requireNonNull(title);
        return this;
    }

    public Boolean getAllMembersAreAdminitrators() {
        return allMembersAreAdminitrators;
    }

    public GroupChat setAllMembersAreAdminitrators(Boolean allMembersAreAdminitrators) {
        this.allMembersAreAdminitrators = Objects.requireNonNull(allMembersAreAdminitrators);
        return this;
    }

    @Override
    public String toString() {
        return "GroupChat{" +
                "title='" + title + '\'' +
                ", allMembersAreAdminitrators=" + allMembersAreAdminitrators +
                ", id=" + id +
                ", photo=" + photo +
                '}';
    }
}
