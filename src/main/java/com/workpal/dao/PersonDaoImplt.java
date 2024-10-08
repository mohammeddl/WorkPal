package main.java.com.workpal.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import main.java.com.workpal.config.DatabaseConnection;
import main.java.com.workpal.model.Event;
import main.java.com.workpal.model.Person;

public class PersonDaoImplt implements PersonDao{

    private final Connection connection;

    public PersonDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void registerUser(String name, String email, String password, String role) {
        String query = "INSERT INTO person (name, email, password, role) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password); 
            stmt.setString(4, role);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registerManager(String name, String email, String password, String role) {
        String query = "INSERT INTO manager (name, email, password, role) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, role);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method for logging in
    public Person login(String email, String password) {
        String query = "SELECT * FROM person WHERE email = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //method for saving a member
    public void saveMember(String name, String password, String email, String role) {
        String query = "INSERT INTO member (name, password, email, role) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, role);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    //method for deleting a member by id
  public void deleteById(int id) {
        String query = "DELETE FROM person WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method for getting all members and managers
    public void getAllMembersAndManagers(){
        String query = "SELECT * FROM person";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Role: " + resultSet.getString("role"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();

    }
}



    //method for getting all members
    public List<Person> getAllMembers() {
        List<Person> members = new ArrayList<>();
        String query = "SELECT * FROM person";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                members.add(new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("role")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    //method for getting all events
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM event";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                events.add(new Event(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("date"),
                        resultSet.getString("location"),
                        resultSet.getInt("manager_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }
}
