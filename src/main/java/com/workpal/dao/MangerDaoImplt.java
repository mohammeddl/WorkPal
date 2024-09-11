package main.java.com.workpal.dao;

import main.java.com.workpal.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class MangerDaoImplt {
    private final Connection connection;

     public MangerDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void addEvent(){
        String query = "INSERT INTO events (name, date, description) VALUES ('name', 'date', 'description')";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public void deleteEvents(int id){
        String query = "DELETE FROM events WHERE id = " + id;
    }

}
