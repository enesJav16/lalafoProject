import database.Database;
import service.serviceImpl.AnnouncementServiceImpl;
import service.serviceImpl.FavoriteServiceImpl;
import service.serviceImpl.UserServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        UserServiceImpl userService = new UserServiceImpl();
        AnnouncementServiceImpl announcementService = new AnnouncementServiceImpl();
        FavoriteServiceImpl favoriteService = new FavoriteServiceImpl();

        while (true) {
            try {
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
                        if (userService.getUserById(id) != null) {
                            System.out.println(userService.getUserById(id));
                        } else {
                            System.out.println("User not found");
                        }
                    }
                    case 3 -> {
                        System.out.println(userService.getAllUsers());
                    }
                    case 4 -> {
                        System.out.println("Type id");
                        long id = sc.nextLong();
                        if (userService.getUserById(id) != null) {
                            userService.updateUser(id, UserServiceImpl.updateUser());
                        } else {
                            System.out.println("User not found");
                        }
                    }
                    case 5 -> {
                        System.out.println("Type id");
                        long id = sc.nextLong();
                        if (userService.getUserById(id) != null) {
                            userService.deleteUser(id);
                        } else {
                            System.out.println("User not found");
                        }
                    }
                    case 6 ->
                            System.out.println(announcementService.addAnnocement(AnnouncementServiceImpl.newAnnoucement(UserServiceImpl.newUser())));
                    case 7 -> {
                        System.out.println("Type Announcement id:");
                        long id = sc.nextLong();
                        if (announcementService.getAnnouncementById(id) != null) {
                            System.out.println(announcementService.getAnnouncementById(id));
                        } else {
                            System.out.println("Announcement not found");
                        }
                    }
                    case 8 -> System.out.println(announcementService.getAllAnnouncement());
                    case 9 -> {
                        System.out.println("Type Announcement id:");
                        long id = sc.nextLong();
                        announcementService.updateAnnouncement(id, AnnouncementServiceImpl.updateAnnoucement(UserServiceImpl.newUser()));
                    }
                    case 10 -> {
                        System.out.println("Type Announcement id You want to delete:");
                        long id = sc.nextLong();
                        announcementService.deleteAnnouncement(id);
                    }
                    case 11 -> {
                        if(Database.users.isEmpty() || Database.annoucements.isEmpty()){
                            System.out.println("Impossible to add bc there is no user or announcement");
                        }else {
                            System.out.println(favoriteService.addFavorite(FavoriteServiceImpl.newFavorite()));
                        }

                    }
                    case 12 -> {
                        System.out.println("Type Favorite id:");
                        long id = sc.nextLong();
                        if (favoriteService.getFavorite(id) != null) {
                            System.out.println(favoriteService.getFavorite(id));
                        } else {
                            System.out.println("Favorite not found");
                        }
                    }
                    case 13 -> System.out.println(favoriteService.getAllFavorites());
                    case 14 -> {
                        System.out.println("Type Favorite id You want to update:");
                        long id = sc.nextLong();
                        if(favoriteService.getFavorite(id)==null){
                            System.out.println("Favorite not found");
                        }else {
                            if(Database.users.isEmpty() || Database.annoucements.isEmpty()){
                                System.out.println(Database.users);
                                System.out.println("Impossible to update bc there is no user or announcement");
                            }else {
                                favoriteService.updateFavorite(id, FavoriteServiceImpl.updateFavorite());
                            }
                        }
                    }
                    case 15 -> {
                        System.out.println("Type Favorite id You want to delete:");
                        long id = sc.nextLong();
                        favoriteService.deleteFavorite(id);
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Please enter a number");
                sc.nextLine();
            }
        }
    }
}
