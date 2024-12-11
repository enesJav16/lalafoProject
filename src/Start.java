import service.serviceImpl.UserServiceImpl;

import java.util.Scanner;

public class Start {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        UserServiceImpl userService = new UserServiceImpl();

        while (true) {
            System.out.println("===================================================================");
            System.out.println("===================================================================");
            System.out.println("""
                    1.Add User          6.Add Announcement           11.Add Favorite
                    2.Get by id         7.Get Announcement by id     12.Get Favorite by id
                    3.Get all           8.Get all Announcement       13.Get all Favorite
                    4.Update User       9.Update Announcement        14.Update Favorite
                    5.Delete User      10.Delete Announcement        15.Delete Favorite
                    """);

            int n = sc.nextInt();
            switch (n) {
                case 1 -> System.out.println(userService.addUser(UserServiceImpl.newUser()));
                case 2 -> {
                    System.out.println("Type id");
                    long id = sc.nextLong();
                    if(userService.getUserById(id)!=null) {
                        System.out.println(userService.getUserById(id));
                    }else {
                        System.out.println("User not found");
                    }
                }
                case 3 -> {
                    System.out.println(userService.getAllUsers());
                }
                case 4 -> {
                    System.out.println("Type id");
                    long id = sc.nextLong();
                    if(userService.getUserById(id)!=null) {
                        userService.updateUser(id, UserServiceImpl.updateUser());
                    }else {
                        System.out.println("User not found");
                    }
                }
                case 5 -> {
                    System.out.println("Type id");
                    long id = sc.nextLong();
                    if(userService.getUserById(id)!=null) {
                        userService.deleteUser(id);
                    }else {
                        System.out.println("User not found");
                    }
                }



            }
        }
    }
}
