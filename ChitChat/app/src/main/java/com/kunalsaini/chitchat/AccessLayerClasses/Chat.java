package com.kunalsaini.chitchat.AccessLayerClasses;

public class Chat {
    private String seen;
    private String timeStamp;
    private String time;
    private String date;
    private String sender;
    private String message;
    private String type;

    public Chat() {
    }

    public Chat(String time, String date, String timeStamp, String sender, String message, String type, String seen) {
        this.time = time;
        this.date = date;
        this.timeStamp = timeStamp;
        this.sender = sender;
        this.message = message;
        this.type = type;
        this.seen = seen;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeen() {
        return seen;
    }

    public void setSeen(String seen) {
        this.seen = seen;
    }
}