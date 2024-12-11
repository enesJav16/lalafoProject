package dao.daoImpl;

import dao.UserDao;
import database.Database;
import models.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public String addUser(User user) {
        Database.users.add(user);
        return "User added successfully!";
    }

    @Override
    public User getUserById(Long id) {
        for (User user : Database.users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return Database.users;
    }

    @Override
    public void updateUser(Long id, User user) {
        boolean found = false;
        for (User user1 : Database.users) {
            if (user1.getId().equals(id)) {
                found = true;
            }
        }

        if (!found) {
            System.out.println("User with id " + id + " not found");
        } else {
            for (User user1 : Database.users) {
                if (user1.getId().equals(id)) {
                    user1.setId(id);
                    user1.setFirstName(user.getFirstName());
                    user1.setEmail(user.getEmail());
                    user1.setPassword(user.getPassword());
                    user1.setRole(user.getRole());
                }
            }
            System.out.println("User with id " + id + " updated successfully");
            System.out.println(getUserById(id));
        }
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        if (user != null) {
            Database.users.remove(user);
            System.out.println("User with id " + id + " deleted successfully");
        }else {
            System.out.println("User with id " + id + " not found");
        }
    }
}
