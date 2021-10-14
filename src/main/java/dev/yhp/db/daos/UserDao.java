package dev.yhp.db.daos;

import dev.yhp.db.models.UserModel;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    // DAO안의 메서드의 이름은 DBMS 쿼리 키워드로 시작한다. (select~, insert~, update~, delete~)
    public UserModel selectUser(Connection connection, String email, String password) throws SQLException {
        UserModel userModel = null;
        String query = "" +
                "SELECT `index`         AS `index`,\n" +
                "       `email`         AS `email`,\n" +
                "       `password`      AS `password`,\n" +
                "       `nickname`      AS `nickname`,\n" +
                "       `name`          AS `name`,\n" +
                "       `contact`       AS `contact`,\n" +
                "       `registered_at` AS `registeredAt`,\n" +
                "       `signed_at`     AS `signedAt`\n" +
                "FROM `s_1`.`users`\n" +
                "WHERE `email` = ?\n" +
                "  AND `password` = ?\n" +
                "LIMIT 1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            /*  preparedStatement.executeUpdate() : int 해당 쿼리를 실행하여서 영향을 받은 레코드의 수를 반환함.
                preparedStatement.execute() : boolean 해당 쿼리를 정상적으로 실행하였는지의 여부만 반환함.
                preparedStatement.executeQuery() : [ResultSet] 해당 쿼리를 실행하여서 반환된 결과 값을 가지는 ResultSet 객체
                를 반환함. (SELECT 실행 시에만 사용)*/

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    userModel = new UserModel(
                            resultSet.getInt("index"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("nickname"),
                            resultSet.getString("name"),
                            resultSet.getString("contact"),
                            resultSet.getDate("registeredAt"),
                            resultSet.getDate("signedAt"));
                }
            }
        }
        return userModel;
    }

    public void insertUser(Connection connection, String email, String password, String nickname, String name,
                           String contact) throws SQLException {

        String query = "" +
                "INSERT INTO `s_1`.`users`(`email`,`password`,`nickname`,`name`,`contact`)\n" +
                "VALUES (?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nickname);
            preparedStatement.setString(4, name);
            preparedStatement.setString(5, contact);
            preparedStatement.executeUpdate();
        }
    }

    public int selectUserCountByEmail(Connection connection, String email) throws SQLException{
        String query = "" +
                "SELECT COUNT(`index`) AS `count` FROM `s_1`.`users` WHERE `email`=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,email);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                resultSet.next();
                return  resultSet.getInt("count");
            }
        }
    }

    public int selectUserCountByNickname(Connection connection, String nickname) throws SQLException{
        String query = "" +
                "SELECT COUNT(`index`) AS `count` FROM `s_1`.`users` WHERE `nickname`=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,nickname);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                resultSet.next();
                return  resultSet.getInt("count");
            }
        }
    }
}
