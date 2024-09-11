package main.java.com.workpal.dao;

import main.java.com.workpal.config.DatabaseConnection;
import main.java.com.workpal.model.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;


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
    

    public List<Event> displayEventsManager(int managerId){
       List<Event> events = new ArrayList<>();
        String req = "SELECT * FROM event WHERE managerid = ? " ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, managerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Event event = new Event(
                        resultSet.getInt("eventId"),
                        resultSet.getString("name"),
                        resultSet.getString("date"),
                        resultSet.getString("location"),
                        resultSet.getInt("managerid")
                );
                events.add(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
        return events;
    }
       

}
