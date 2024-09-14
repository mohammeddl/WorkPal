package main.java.com.workpal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.com.workpal.config.DatabaseConnection;
import main.java.com.workpal.model.Member;
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


     public Member findByEmail(String email) {
        String query = "SELECT * FROM member WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return new Member(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("role"),
                    resultSet.getString("temporary_password")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void updateTemporaryPassword(int memberId, String tempPassword) {
        String query = "UPDATE member SET temporary_password = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, tempPassword);
            stmt.setInt(2, memberId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updatePassword(int memberId, String newPassword) {
        String query = "UPDATE member SET password = ?, temporary_password = NULL WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newPassword);
            stmt.setInt(2, memberId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
