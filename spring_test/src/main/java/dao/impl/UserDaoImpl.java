package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<User> findAll() {
        List<User> users = null;
        try {
            users = template.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        } catch (DataAccessException e) {
            System.out.println("UserDao findAll exception...");
        }
        return users;
    }

    public Long save(final User user) {
//        template.update("insert into sys_user values(?, ?, ?, ?, ?)", null, user.getUsername(),
//                user.getEmail(), user.getPassword(), user.getPhoneNum());

        // 创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement("insert into sys_user values(?, ?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, null);
                statement.setString(2, user.getUsername());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getPassword());
                statement.setString(5, user.getPhoneNum());
                return statement;
            }
        };

        // 创建GeneratedKeyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(creator, keyHolder);
        long userId = keyHolder.getKey().longValue();
        return userId;
    }

    public void saveUserRoleRel(Long id, Long[] roleIds) {
        for (Long roleId : roleIds) {
            template.update("insert into sys_user_role values(?, ?)", id, roleId);
        }
    }

    public void delUserRoleRel(Long userId) {
        template.update("delete from sys_user_role where userId = ?", userId);
    }

    public void delUser(Long userId) {
        template.update("delete from sys_user where id = ?", userId);
    }
}
