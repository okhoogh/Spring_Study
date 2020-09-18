package mapper;

import domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findUserAndOrderAll();

    List<User> findUserAndRoleAll();
}
