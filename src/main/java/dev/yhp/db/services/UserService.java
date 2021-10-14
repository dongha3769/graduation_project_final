package dev.yhp.db.services;

import dev.yhp.db.daos.UserDao;
import dev.yhp.db.enums.user.LoginResult;
import dev.yhp.db.enums.user.RegisterResult;
import dev.yhp.db.models.UserModel;
import dev.yhp.db.util.CryptoUtil;
import dev.yhp.db.vos.user.LoginVo;
import dev.yhp.db.vos.user.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class UserService {
    private final DataSource datasource;
    private final UserDao userDao;

    @Autowired
    public UserService(DataSource datasource, UserDao userDao) {
        this.datasource = datasource;
        this.userDao = userDao;
    }

    public void login(LoginVo loginVo) throws SQLException {
        // 정규화가 우선
        // Try-With-Resource
        // try ( ? AutoCloseable ) { . . . }
        try (Connection connection = this.datasource.getConnection()) {
            UserModel userModel = this.userDao.selectUser(connection, loginVo.getEmail(), loginVo.getHasedPassword());
            if (userModel == null) {
                System.out.println("로그인 실패");
                loginVo.setResult(LoginResult.FAILURE);
            } else {
                System.out.println("로그인 성공 (닉네임 : " + userModel.getNickname() + ")");

                loginVo.setUserModel(userModel);
                loginVo.setResult(LoginResult.SUCCESS);
            }
        }
    }

    public void register(RegisterVo registerVo) throws SQLException {
        try (Connection connection = this.datasource.getConnection()) {
            if(this.userDao.selectUserCountByEmail(connection, registerVo.getEmail()) > 0){
                registerVo.setResult(RegisterResult.DUPLICATE_EMAIL);
                return;
            }
            if(this.userDao.selectUserCountByNickname(connection, registerVo.getNickname()) > 0){
                registerVo.setResult(RegisterResult.DUPLICATE_NICKNAME);
                return;
            }
            this.userDao.insertUser(
                    connection,
                    registerVo.getEmail(),
                    registerVo.getHasedPassword(),
                    registerVo.getNickname(),
                    registerVo.getName(),
                    registerVo.getContact());
            registerVo.setResult(RegisterResult.SUCCESS);
        }
    }
}
