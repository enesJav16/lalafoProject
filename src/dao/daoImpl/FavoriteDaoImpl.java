package dao.daoImpl;

import dao.FavoriteDao;
import database.Database;
import models.Favorite;

import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {
    @Override
    public Favorite getFavorite(Long id) {
        // Favorite favorite = new Favorite();
        // favorite.setId(id);
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
    public Favorite updateFavorite(Long id, Favorite favorite) {
        for (Favorite favorite1 : Database.favorites) {
            if (favorite1.getId().equals(id)) {
                Database.favorites.remove(favorite1);
                Database.favorites.add(favorite);
                return favorite;
            }
        }
        return null;
    }

    @Override
    public void deleteFavorite(Long id) {
        for (Favorite favorite : Database.favorites) {
            if (favorite.getId().equals(id)) {
                Database.favorites.remove(getFavorite(id));
            }
        }
    }
}
