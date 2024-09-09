package Menu;

import java.util.Scanner;

import main.java.com.workpal.model.Admin;
import main.java.com.workpal.model.Person;
import main.java.com.workpal.repository.PersonRepository;
import main.java.com.workpal.service.AdminService;

public class LoginMenu {

    private static PersonRepository personRepository;
    private static AdminService adminService;

    public LoginMenu(PersonRepository personRepository, AdminService adminService) {
        this.personRepository = personRepository;
        this.adminService = adminService;
    }

    public static void displayLoginMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        
        Person  person = personRepository.findByEmailAndPassword(email, password);

        if (person != null) {
            System.out.println("Welcome " + person.getName());
        
            if (person instanceof Admin) {
                AdminMenu.displayAdminMenu(adminService);
            } else {
                System.out.println("You are not authorized to manage members.");
            }
        } else {
            System.out.println("Invalid email or password!");
        }
    }
}
