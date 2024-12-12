package dao.daoImpl;

import dao.UserDao;
import database.Database;
import models.Annoucement;
import models.Favorite;
import models.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
    public void deleteUser(Long id) throws InputMismatchException {
        User user = getUserById(id);
        if (user != null) {
            while (true) {
                try {
                    System.out.println("How do you want to delete this user?");
                    System.out.println("Delete all related data (Announcement/Favorite) [0]");
                    System.out.println("Delete just User                                [1]");
                    int n=new Scanner(System.in).nextInt();

                    switch (n){
                        case 0 ->{
                            Favorite fa = null;
                            Annoucement an = null;

                            boolean check = false;
                            boolean check1 = false;

                            for(Annoucement a:Database.annoucements){
                                if(a.getOwner()==user){
                                    an=a;
                                    check = true;
                                }
                            }
                            for(Favorite f:Database.favorites){
                                if(f.getWhoLiked()==user){
                                    fa=f;
                                    check1 = true;
                                }
                            }
                            if(check){
                                Database.annoucements.remove(an);
                            }
                            if (check1) {
                                Database.favorites.remove(fa);
                            }
                            Database.users.remove(user);
                            System.out.println("User with id " + id + " and all related data is deleted successfully");
                        }
                        case 1 ->{
                            Database.users.remove(user);
                            System.out.println("User with id " + id + " deleted successfully");
                        }
                        default -> {}
                    }
                    break;
                }catch (InputMismatchException e) {
                    System.out.println("Give number.");
                }
            }
        }else {
            System.out.println("User with id " + id + " not found");
        }
    }
}
