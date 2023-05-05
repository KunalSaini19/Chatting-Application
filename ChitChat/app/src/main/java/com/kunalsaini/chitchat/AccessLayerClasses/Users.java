package com.kunalsaini.chitchat.AccessLayerClasses;

public class Users {
    private String email;
    private String fullName;
    private String profileExist;
    private String uid;
    //private String adminVerified;

    public Users() {
    }

    public Users(String fullName, String uid, String email, String profileExist) {
        this.fullName = fullName;
        this.uid = uid;
        this.email = email;
        this.profileExist = profileExist;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getProfileExist() {
        return profileExist;
    }

    public void setProfileExist(String profileExist) {
        this.profileExist = profileExist;
    }
}
