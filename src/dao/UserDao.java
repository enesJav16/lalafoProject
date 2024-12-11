package dao;

import models.User;

import java.util.List;

public interface UserDao {
    String addUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
