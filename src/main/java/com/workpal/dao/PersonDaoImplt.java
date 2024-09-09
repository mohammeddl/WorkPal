package main.java.com.workpal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 

import java.sql.SQLException;

import main.java.com.workpal.config.DatabaseConnection;
import main.java.com.workpal.model.Person;

public class PersonDaoImplt implements PersonDao{

    private final Connection connection;

    public PersonDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }


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
                        resultSet.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void save(Person person) {
        String query = "INSERT INTO persons (name, password, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getPassword());
            stmt.setString(3, person.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  public void deleteById(int id) {
        String query = "DELETE FROM persons WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
