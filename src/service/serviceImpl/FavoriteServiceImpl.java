package service.serviceImpl;

import dao.FavoriteDao;
import dao.daoImpl.FavoriteDaoImpl;
import database.Database;
import generateId.GenerateId;
import models.Annoucement;
import models.Favorite;
import models.User;
import service.FavoriteService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FavoriteServiceImpl implements FavoriteService {
    FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public String addFavorite(Favorite favorite) {
        Database.favorites.add(favorite);
        return "Favorite added";
    }

    @Override
    public Favorite getFavorite(Long id) {
        return favoriteDao.getFavorite(id);
    }

    @Override
    public List<Favorite> getAllFavorites() {
        return favoriteDao.getAllFavorites();
    }

    @Override
    public void updateFavorite(Long id, Favorite favorite) {
        favoriteDao.updateFavorite(id, favorite);
    }

    @Override
    public void deleteFavorite(Long id) {
        favoriteDao.deleteFavorite(id);
    }

    public static Favorite newFavorite() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        Favorite favorite=new Favorite();

        User user = null;
        Annoucement announcement = null;

        favorite.setId(GenerateId.favoriteId());

        while (true) {
            try {
                boolean check = true;
                while (check) {
                    System.out.println("Give Owner(User) id:");
                    long userId = scanner.nextLong();

                    for (User u : Database.users) {
                        if (u.getId() == userId) {
                            user = u;
                        }
                    }
                    if (user != null) {
                        favorite.setWhoLiked(user);
                        check = false;
                    } else {
                        System.out.println("User not found");
                    }
                }
                break;
            }catch (InputMismatchException e) {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }

        while (true) {
            try {
                boolean check1 = true;
                while (check1) {
                    System.out.println("Give Annoucement id:");
                    long announcementId = scanner.nextLong();
                    for (Annoucement a : Database.annoucements) {
                        if (a.getId() == announcementId) {
                            announcement = a;
                        }
                    }

                    if (announcement != null) {
                        favorite.setAnnouncement(announcement);
                        check1 = false;
                    } else {
                        System.out.println("Announcement not found");
                    }
                }
                break;

            }catch (InputMismatchException e) {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }
        return favorite;
    }

    public static Favorite updateFavorite() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        Favorite favorite=newFavorite();

        User user = null;
        Annoucement announcement = null;


        while (true) {
            try {
                boolean check = true;
                while (check) {
                    System.out.println("Give Owner(User) id:");
                    long userId = scanner.nextLong();

                    for (User u : Database.users) {
                        if (u.getId() == userId) {
                            user = u;
                        }
                    }

                    if (user != null) {
                        favorite.setWhoLiked(user);
                        check = false;
                    } else {
                        System.out.println("User not found");
                    }
                }
                break;

            }catch (InputMismatchException e) {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }


        while (true) {
            try {
                boolean check1 = true;
                while (check1) {
                    System.out.println("Give Annoucement id:");
                    long announcementId = scanner.nextLong();
                    for (Annoucement a : Database.annoucements) {
                        if (a.getId() == announcementId) {
                            announcement = a;
                        }
                    }

                    if (announcement != null) {
                        favorite.setAnnouncement(announcement);
                        check1 = false;
                    } else {
                        System.out.println("Announcement not found");
                    }
                }
                break;
            }catch (InputMismatchException e) {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }
        return favorite;
    }
}
