package cdu.lhj.dao.impl;

import cdu.lhj.dao.UserDao;
import cdu.lhj.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User loginCheck(String username, String password) {
        User user = new User();
        String sql = "SELECT *FROM mydb.user_table WHERE username=? and password=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()){
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (user.getName() == null) {
            return null;
        } else {
            return user;
        }
    }
}
