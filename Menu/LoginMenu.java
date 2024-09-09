package Menu;

import java.util.Scanner;

import main.java.com.workpal.model.Admin;
import main.java.com.workpal.model.Person;
import main.java.com.workpal.repository.AdminRepositoryImplt;
import main.java.com.workpal.repository.PersonRepositoryImplt;

import main.java.com.workpal.service.AdminServiceImplt;

public class LoginMenu {

    private static PersonRepositoryImplt personRepositoryImplt;
    private static AdminRepositoryImplt adminRepositoryImplt;

    public LoginMenu(PersonRepositoryImplt personRepositoryImplt, AdminRepositoryImplt adminRepositoryImplt) {
        LoginMenu.personRepositoryImplt = personRepositoryImplt;
        LoginMenu.adminRepositoryImplt = adminRepositoryImplt;
    }

    public static void displayLoginMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        // if (personRepositoryImplt == null) {
        //     System.out.println("PersonRepository is not initialized!");
        //     return;
        // }

        Person  person = personRepositoryImplt.findByEmailAndPassword(email, password);

        if (person != null) {
            System.out.println("Welcome " + person.getName());
            System.out.println("you are admin" + (person instanceof Admin));
        
            if (person.getRole().equals("admin")) {
                AdminMenu.displayAdminMenu(adminRepositoryImplt);
            } else {
                System.out.println("You are not authorized to manage members.");
            }
        } else {
            System.out.println("Invalid email or password!");
        }
    }
}
