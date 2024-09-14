package main.java.com.workpal.dao;

import main.java.com.workpal.model.FavoriteSpace;
import java.util.List;

public interface FavoriteDao {

    void addFavorite(int memberId, int spaceId);
    List<FavoriteSpace> displayFavorites(int memberId);
    
} 
