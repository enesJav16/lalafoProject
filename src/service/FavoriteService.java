package service;

import models.Favorite;

import java.util.List;

public interface FavoriteService {
    Favorite getFavorite(Long id);
    List<Favorite> getAllFavorites();
   void updateFavorite(Long id, Favorite favorite);
    void deleteFavorite(Long id);
}
