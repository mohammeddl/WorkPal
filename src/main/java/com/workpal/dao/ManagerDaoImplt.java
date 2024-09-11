package main.java.com.workpal.dao;

import main.java.com.workpal.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class ManagerDaoImplt implements ManagerDao {
    private final Connection connection;

     public ManagerDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void addEvent(int mangerId, String name, String date, String location){
        String query = "INSERT INTO event ( name, date, location, managerid) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, location);
            preparedStatement.setInt(4, mangerId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
    }
}

    public void deleteEvents(int id){
        String query = "DELETE FROM event WHERE id = " + id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
    }
    }

}
