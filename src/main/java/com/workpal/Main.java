package main.java.com.workpal;

import Menu.LoginMenu;
import main.java.com.workpal.dao.PersonDaoImplt;
import main.java.com.workpal.repository.AdminRepositoryImplt;
import main.java.com.workpal.repository.PersonRepositoryImplt;
// import main.java.com.workpal.service.AdminServiceImplt;

// import main.java.com.workpal.config.DatabaseConnection;

public class Main {
    

    
    public static void main(String[] args){
        PersonDaoImplt personDao = new PersonDaoImplt();
        PersonRepositoryImplt personRepository = new PersonRepositoryImplt(personDao);
        AdminRepositoryImplt adminRepositoryImplt = new AdminRepositoryImplt(personDao);



        new LoginMenu(personRepository, adminRepositoryImplt);

    LoginMenu.displayLoginMenu();
    //  DatabaseConnection dbConnection = DatabaseConnection.getInstance();

    //     if (dbConnection.isConnectionValid()) {
    //         System.out.println("Connected to the database successfully.");
    //     } else {
    //         System.out.println("Failed to connect to the database.");
        
    // }

    }
}
