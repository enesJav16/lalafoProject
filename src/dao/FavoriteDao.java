package dao;

import models.Favorite;

import java.util.List;

public interface FavoriteDao {
    //String addFavorite(Favorite favorite);
    Favorite getFavorite(Long id);
    List<Favorite> getAllFavorites();
    void updateFavorite(Long id, Favorite favorite);
    void deleteFavorite(Long id);







}
