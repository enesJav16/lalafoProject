package dao.daoImpl;

import dao.FavoriteDao;
import database.Database;
import models.Favorite;

import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {
    @Override
    public Favorite getFavorite(Long id) {
        for (Favorite favorite : Database.favorites) {
            if (favorite.getId().equals(id)) {
                return favorite;
            }
        }
        return null;
    }

    @Override
    public List<Favorite> getAllFavorites() {
        return Database.favorites;
    }

    @Override
    public void updateFavorite(Long id, Favorite favorite) {
        boolean found = false;
        for (Favorite f : Database.favorites) {
            if (f.getId().equals(id)) {
                found = true;
            }
        }
        if (!found) {
            System.out.println("Favorite not found");

        } else {
            for (Favorite f : Database.favorites) {
                if (f.getId().equals(id)) {
                    f.setId(id);
                    f.setWhoLiked(favorite.getWhoLiked());
                    f.setAnnouncement(favorite.getAnnouncement());
                }
            }
            System.out.println("Favorite updated");
            System.out.println(getFavorite(id));
        }
    }

    @Override
    public void deleteFavorite(Long id) {
       Favorite favorite = getFavorite(id);
       if (favorite != null) {
           Database.favorites.remove(favorite);
           System.out.println("Favorite deleted");
       }else {
           System.out.println("Favorite not found");

       }
    }
}

