package main.java.com.workpal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.java.com.workpal.config.DatabaseConnection;

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



}
