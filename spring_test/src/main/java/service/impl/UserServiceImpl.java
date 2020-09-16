package service.impl;

import dao.RoleDao;
import dao.UserDao;
import domain.Role;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<User> findAll() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            List<Role> roles = roleDao.findRolesByUserId(user.getId());
            user.setRoles(roles);
        }
        return userList;
    }

    public void save(User user, Long[] roleIds) {
        // 1.向sys_user存储user信息
        Long userId = userDao.save(user);
        // 2.向sys_user_role存储user和role的关系
        userDao.saveUserRoleRel(userId, roleIds);
    }

    public void delUser(Long userId) {
        // 1.删除sys_user_role关系
        userDao.delUserRoleRel(userId);
        // 2.删除sys_user记录
        userDao.delUser(userId);
    }
}
