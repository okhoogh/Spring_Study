package dao;

import domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {

    List<User> findAll() throws IOException;

    User findById(int id);

    List<User> findByCondition(User user);

    List<User> findByIds(List<Integer> ids);
}
