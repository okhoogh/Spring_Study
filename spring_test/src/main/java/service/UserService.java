package service;

import domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user, Long[] roleIds);

    void delUser(Long userId);
}
