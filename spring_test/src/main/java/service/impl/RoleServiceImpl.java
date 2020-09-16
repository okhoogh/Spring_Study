package service.impl;

import dao.RoleDao;
import domain.Role;
import service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> findAll() {
        return roleDao.findAll();
    }

    public void save(Role role) {
        roleDao.save(role);
    }

}
