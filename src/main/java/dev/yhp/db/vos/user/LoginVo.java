package dev.yhp.db.vos.user;

import dev.yhp.db.enums.user.LoginResult;
import dev.yhp.db.models.UserModel;
import dev.yhp.db.util.CryptoUtil;
import org.springframework.http.converter.json.GsonBuilderUtils;

public class LoginVo {
    private String email;
    private String password;

    private String hasedPassword;
    private UserModel userModel;
    private LoginResult result;

    public LoginVo() {
    }

    public LoginVo(String email, String password) {
        this.email = email;
        this.setPassword(password);
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

    public String getHasedPassword() {
        return hasedPassword;
    }

    public LoginResult getResult() {
        return result;
    }

    public void setResult(LoginResult result) {
        this.result = result;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
