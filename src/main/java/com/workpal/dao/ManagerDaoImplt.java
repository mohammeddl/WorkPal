package main.java.com.workpal.dao;

import main.java.com.workpal.config.DatabaseConnection;
import main.java.com.workpal.model.Event;
import main.java.com.workpal.model.Service;

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

    public void deleteEvents(int managerId, int eventId){
        String query = "DELETE FROM event WHERE managerid = ? AND eventId = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, managerId);
            preparedStatement.setInt(2, eventId);
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
       


    public void updateEvent(int eventId, int managerId, String name, String date, String location){
        String query = "UPDATE event SET name = ?, date = ?, location = ? WHERE eventId = ? AND managerid = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, location);
            preparedStatement.setInt(4, eventId);
            preparedStatement.setInt(5, managerId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
    }
}



//services

   public void addService(int mangerId, String food){
        String query = "INSERT INTO service ( managerid, food) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, mangerId);
            preparedStatement.setString(2, food);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
    }
}

    public void deleteService(int managerId, int serviceId){
        String query = "DELETE FROM service WHERE managerid = ? AND serviceId = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, managerId);
            preparedStatement.setInt(2, serviceId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
}

    public void updateService(int serviceId, int managerId, String food){
        String query = "UPDATE service SET food = ? WHERE serviceId = ? AND managerid = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, food);
            preparedStatement.setInt(2, serviceId);
            preparedStatement.setInt(3, managerId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
    }
}

    public List<Service> displayServicesManager(int managerId){
        List<Service> services = new ArrayList<>();
        String req = "SELECT * FROM service WHERE managerid = ? " ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, managerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Service service = new Service(
                        resultSet.getInt("serviceId"),
                        resultSet.getInt("managerid"),
                        resultSet.getString("food")
                );
                services.add(service);
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
        return services;
    }
}
