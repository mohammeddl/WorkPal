package main.java.com.workpal.service;

import main.java.com.workpal.model.FavoriteSpace;
import java.util.List;

public interface FavoriteService {

    void addFavorite(int memberId, int spaceId);
    List<FavoriteSpace> displayFavorites(int memberId);
    
} 