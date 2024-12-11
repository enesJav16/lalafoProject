package service.serviceImpl;

import dao.UserDao;
import dao.daoImpl.UserDaoImpl;
import enums.Role;
import generateId.GenerateId;
import models.User;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public String addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void updateUser(Long id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    public static User newUser() throws IllegalArgumentException{
        Scanner sc = new Scanner(System.in);
        User user = new User();

        user.setId(GenerateId.userId());
        System.out.println("Give user name: ");
        user.setFirstName(sc.nextLine());
        System.out.println("Give user email: ");
        user.setEmail(sc.nextLine());
        System.out.println("Give user password: ");
        user.setPassword(sc.nextLine());
        while (true) {
            try {
                System.out.println("Give user role(ADMIN/USER/VENDOR): ");
                String role = sc.nextLine();
                user.setRole(Role.valueOf(role.toUpperCase()));
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Invalid role");
            }
        }
        return user;
    }
    public static User updateUser() throws IllegalArgumentException{
        Scanner sc = new Scanner(System.in);
        User user = new User();

        System.out.println("Give user name: ");
        user.setFirstName(sc.nextLine());
        System.out.println("Give user email: ");
        user.setEmail(sc.nextLine());
        System.out.println("Give user password: ");
        user.setPassword(sc.nextLine());
        while (true) {
            try {
                System.out.println("Give user role(ADMIN/USER/VENDOR): ");
                String role = sc.nextLine();
                user.setRole(Role.valueOf(role.toUpperCase()));
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Invalid role");
            }
        }
        return user;
    }
}
