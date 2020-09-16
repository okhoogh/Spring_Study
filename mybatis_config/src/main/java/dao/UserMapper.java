package dao;

import domain.User;

public interface UserMapper {

    void save(User user);

    User findById(int id);
}
