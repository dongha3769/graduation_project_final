package dev.yhp.db.models;

import java.util.Date;

public class UserModel {
    public static final String Name = "userModel";

    private final int index;
    private final String email;
    private final String password;
    private final String nickname;
    private final String name;
    private final String contact;
    private final Date registeredAt;
    private final Date signedAt;

    public UserModel(int index, String email, String password, String nickname, String name, String contact, Date registeredAt, Date signedAt) {
        this.index = index;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.contact = contact;
        this.registeredAt = registeredAt;
        this.signedAt = signedAt;
    }

    public int getIndex() {
        return index;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public Date getSignedAt() {
        return signedAt;
    }
}
