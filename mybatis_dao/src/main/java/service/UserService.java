package service;

import domain.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<User> findAll() throws IOException;
}
