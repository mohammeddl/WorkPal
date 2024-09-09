package main.java.com.workpal;

import main.java.com.workpal.config.DatabaseConnection;

public class Main {
    

    public static void main(String[] args){
    // Menu.LoginMenu.displayLoginMenu();
     DatabaseConnection dbConnection = DatabaseConnection.getInstance();

        if (dbConnection.isConnectionValid()) {
            System.out.println("Connected to the database successfully.");
        } else {
            System.out.println("Failed to connect to the database.");
        
    }

    }
}
