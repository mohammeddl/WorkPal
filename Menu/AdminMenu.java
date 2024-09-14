package Menu;

import java.util.List;
import java.util.Scanner;

import main.java.com.workpal.model.Event;
import main.java.com.workpal.model.Person;
import main.java.com.workpal.service.AdminServiceImplt;
import main.java.com.workpal.service.PersonServiceImplt;



public class AdminMenu {

    private static PersonServiceImplt personService;
    
    public static void displayAdminMenu(AdminServiceImplt adminServiceImplt) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Member");
            System.out.println("2. Delete Member");
            System.out.println("3. display all members and managers");
            System.out.println("4. Raport");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.println("Enter role: ");
                    String role = scanner.nextLine();
                    adminServiceImplt.addMember(name, email, password,role);
                    break;
                case 2:
                    System.out.println("Enter member ID to delete: ");
                    int id = scanner.nextInt();
                    adminServiceImplt.deletePerson(id);
                    break;
                case 3:
                    adminServiceImplt.displayAllMembers();
                    break;
                case 4:
                displayRaport();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void displayRaport() {
        System.out.println("Raport:");
        List<Person> members = personService.getAllMembers();
        members.forEach(member -> System.out.println(member));
        List<Event> events = personService.getAllEvents();
        events.forEach(event -> System.out.println(event));

    }
}