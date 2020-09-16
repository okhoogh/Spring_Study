package dao.impl;

import dao.RoleDao;
import domain.Role;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<Role> findAll() {
        List<Role> roles = null;
        try {
            roles = template.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        } catch (DataAccessException e) {
            System.out.println("RoleDao findAll exception...");
        }
        return roles;
    }

    public void save(Role role) {
        template.update("insert into sys_role values(?, ?, ?)", null, role.getRoleName(), role.getRoleDesc());
    }

    public List<Role> findRolesByUserId(Long id) {
        String sql = "select * from sys_role r, sys_user_role ur where ur.roleId = r.id and ur.userId = ?";
        List<Role> roleList = null;
        try {
            roleList = template.query(sql, new BeanPropertyRowMapper<Role>(Role.class), id);
        } catch (DataAccessException e) {
            System.out.println("RoleDao findRolesByUserId exception...");
        }
        return roleList;
    }
}
