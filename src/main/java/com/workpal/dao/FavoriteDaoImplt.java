package main.java.com.workpal.dao;

import main.java.com.workpal.config.DatabaseConnection;
import main.java.com.workpal.model.FavoriteSpace;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDaoImplt implements FavoriteDao {

    private final Connection connection;


    public FavoriteDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }



    public void addFavorite(int memberId, int spaceId) {
        String query = "INSERT INTO favorite_space (memberId, spaceId) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, memberId);
            preparedStatement.setInt(2, spaceId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<FavoriteSpace> displayFavorites(int memberId) {
        List<FavoriteSpace> favoriteSpaces = new ArrayList<>();
        String req = "SELECT * FROM favorite_space WHERE memberId = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, memberId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FavoriteSpace favoriteSpace = new FavoriteSpace(
                        resultSet.getInt("favoriteId"),
                        resultSet.getInt("memberId"),
                        resultSet.getInt("spaceId"),
                        resultSet.getString("dateAdded")
                );
                favoriteSpaces.add(favoriteSpace);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return favoriteSpaces;
    }
    
}
