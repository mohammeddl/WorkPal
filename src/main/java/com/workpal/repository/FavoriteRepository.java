package main.java.com.workpal.repository;

import main.java.com.workpal.model.FavoriteSpace;
import java.util.List;
public interface FavoriteRepository {

    void addFavorite(int memberId, int spaceId);
    List<FavoriteSpace> displayFavorites(int memberId);
    
} 
