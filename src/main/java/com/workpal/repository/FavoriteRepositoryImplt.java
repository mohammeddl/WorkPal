package main.java.com.workpal.repository;

import main.java.com.workpal.dao.FavoriteDaoImplt;
import main.java.com.workpal.model.FavoriteSpace;
import java.util.List;

public class FavoriteRepositoryImplt implements FavoriteRepository {

    private final FavoriteDaoImplt favoriteDao;

    public FavoriteRepositoryImplt(FavoriteDaoImplt favoriteDao) {
        this.favoriteDao = favoriteDao;
    }


    
    public void addFavorite(int memberId, int spaceId) {
        favoriteDao.addFavorite(memberId, spaceId);
    }
    
    public List<FavoriteSpace> displayFavorites(int memberId) {
        return favoriteDao.displayFavorites(memberId);
    }
    
}
