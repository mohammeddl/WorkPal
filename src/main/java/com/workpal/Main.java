package main.java.com.workpal;

import Menu.LoginMenu;
import Menu.RegisterMenu;
import Menu.ManagerMenu; 
import main.java.com.workpal.dao.ManagerDaoImplt;
import main.java.com.workpal.dao.MemberDaoImplt;
import main.java.com.workpal.dao.PersonDaoImplt;
import main.java.com.workpal.repository.AdminRepositoryImplt;
import main.java.com.workpal.repository.ManagerRepositoryImplt;
import main.java.com.workpal.repository.MemberRepositoryImplt;
import main.java.com.workpal.repository.PersonRepositoryImplt;
// import main.java.com.workpal.service.AdminServiceImplt;
import main.java.com.workpal.service.AdminServiceImplt;
import main.java.com.workpal.service.ManagerServiceImplt;
import main.java.com.workpal.service.MemberServiceImplt;
import main.java.com.workpal.service.PersonServiceImplt;

// import main.java.com.workpal.config.DatabaseConnection;

public class Main {
    

    
    public static void main(String[] args){
        PersonDaoImplt personDao = new PersonDaoImplt();
        MemberDaoImplt memberDao = new MemberDaoImplt();
        ManagerDaoImplt managerDao = new ManagerDaoImplt();

        PersonRepositoryImplt personRepository = new PersonRepositoryImplt(personDao);
        AdminRepositoryImplt adminRepositoryImplt = new AdminRepositoryImplt(personDao);
        MemberRepositoryImplt memberRepositoryImplt = new MemberRepositoryImplt(memberDao);
        ManagerRepositoryImplt managerRepositoryImplt = new ManagerRepositoryImplt(managerDao);
        
        AdminServiceImplt adminServiceImplt = new AdminServiceImplt(adminRepositoryImplt);
        MemberServiceImplt memberServiceImplt = new MemberServiceImplt(memberRepositoryImplt);
        PersonServiceImplt personServiceImplt = new PersonServiceImplt(personRepository);
        ManagerServiceImplt managerServiceImplt = new ManagerServiceImplt(managerRepositoryImplt);


        new LoginMenu(personRepository, adminServiceImplt, memberServiceImplt, managerServiceImplt);
        new RegisterMenu(personServiceImplt, adminServiceImplt);

        RegisterMenu.mainRegisterMenu();
        LoginMenu.displayLoginMenu();


    //  DatabaseConnection dbConnection = DatabaseConnection.getInstance();

    //     if (dbConnection.isConnectionValid()) {
    //         System.out.println("Connected to the database successfully.");
    //     } else {
    //         System.out.println("Failed to connect to the database.");
        
    // }

    }
}
