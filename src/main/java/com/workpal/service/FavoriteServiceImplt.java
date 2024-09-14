package main.java.com.workpal.service;

import main.java.com.workpal.repository.FavoriteRepositoryImplt;
import main.java.com.workpal.model.FavoriteSpace;
import java.util.List;

public class FavoriteServiceImplt implements FavoriteService {

    private final FavoriteRepositoryImplt favoriteRepository;

    public FavoriteServiceImplt(FavoriteRepositoryImplt favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    
    public void addFavorite(int memberId, int spaceId) {
        favoriteRepository.addFavorite(memberId, spaceId);
    }
    
    public List<FavoriteSpace> displayFavorites(int memberId) {
        return favoriteRepository.displayFavorites(memberId);
    }
    
}
