package main.java.com.workpal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.com.workpal.config.DatabaseConnection;
import main.java.com.workpal.model.Space;

public class MemberDaoImplt {

     private final Connection connection;

    public MemberDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
    
    // method for modifying profile
      public void modifyProfile(int id, String name, String email) {
        String query = "UPDATE member SET name = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id); 
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


   public List<Space> viewAllSpaces() {
        List<Space> spaces = new ArrayList<>();
        String query = "SELECT * FROM space";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Space space = new Space(
                        resultSet.getInt("spaceId"),
                        resultSet.getString("type"),
                        resultSet.getString("date"),
                        resultSet.getString("status"),
                        resultSet.getInt("managerId")
                );
                spaces.add(space);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spaces;
    }

}
