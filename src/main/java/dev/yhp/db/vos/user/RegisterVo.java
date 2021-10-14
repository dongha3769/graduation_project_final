package dev.yhp.db.vos.user;

import dev.yhp.db.enums.user.RegisterResult;
import dev.yhp.db.util.CryptoUtil;

public class RegisterVo {
    private String email;
    private String password;
    private String nickname;
    private String name;
    private String contact;

    private String hasedPassword;
    private RegisterResult result;
    public RegisterVo() {
    }

    public RegisterVo(String email, String password, String nickname, String name, String contact) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.hasedPassword = CryptoUtil.Sha512.hash(password);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getHasedPassword() {
        return hasedPassword;
    }

    public RegisterResult getResult() {
        return result;
    }

    public void setResult(RegisterResult result) {
        this.result = result;
    }
}
