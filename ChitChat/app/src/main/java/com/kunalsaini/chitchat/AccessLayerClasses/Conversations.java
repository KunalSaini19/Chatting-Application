package com.kunalsaini.chitchat.AccessLayerClasses;

public class Conversations {
    private String uid;
    private String date;
    private String time;
    private String sender;
    private String message;
    private String name;
    private String seen;
    private String unreadCount;

    public Conversations() {
    }

    public Conversations(String uid, String date, String time, String sender, String message,
                         String name, String seen, String unreadCount) {
        this.uid = uid;
        this.date = date;
        this.time = time;
        this.sender = sender;
        this.message = message;
        this.name = name;
        this.seen = seen;
        this.unreadCount = unreadCount;
    }

    public String getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(String unreadCount) {
        this.unreadCount = unreadCount;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeen() {
        return seen;
    }

    public void setSeen(String seen) {
        this.seen = seen;
    }
}
