package service.serviceImpl;

import dao.FavoriteDao;
import dao.daoImpl.FavoriteDaoImpl;
import models.Favorite;
import service.FavoriteService;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();
    @Override
    public Favorite getFavorite(Long id) {
        return favoriteDao.getFavorite(id);
    }

    @Override
    public List<Favorite> getAllFavorites() {
        return favoriteDao.getAllFavorites();
    }

    @Override
    public Favorite updateFavorite(Long id, Favorite favorite) {
        return favoriteDao.updateFavorite(id, favorite);
    }

    @Override
    public void deleteFavorite(Long id) {
        favoriteDao.deleteFavorite(id);

    }
}
