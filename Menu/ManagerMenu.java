package Menu;

import java.util.Scanner;
import main.java.com.workpal.model.Person;
import main.java.com.workpal.service.ManagerServiceImplt;

public class ManagerMenu {

    private Scanner scanner = new Scanner(System.in); // Use instance field for scanner
    private ManagerServiceImplt managerServiceImplt; // Use instance field for service

    // Constructor to initialize ManagerServiceImplt
    public ManagerMenu(ManagerServiceImplt managerServiceImplt) {
        this.managerServiceImplt = managerServiceImplt; // Set the service instance
    }

    // Method to display the main menu for the manager
    public void mainManagerMenu(Person person) {
        while (true) {
            displayManagerMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    manageEvents(person); // Call the instance method
                    break;
                case 2:
                    // manageSpaces();
                    break;
                case 3:
                    // manageServices();
                    break;
                case 4:
                    // manageSubscriptions();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Method to display the manager menu
    public void displayManagerMenu() {
        System.out.println("1. Manage Events");
        System.out.println("2. Manage Spaces");
        System.out.println("3. Manage Services");
        System.out.println("4. Manage Subscriptions");
        System.out.println("5. Back to main menu");
        System.out.print("Choose an option: ");
    }

    // Method to manage events
    public void manageEvents(Person person) {
        System.out.println("Manage Events");
        System.out.println("1. Add Event");
        System.out.println("2. Update Event");
        System.out.println("3. Delete Event");
        System.out.println("4. View Events");
        System.out.println("5. Back to main menu");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter event name: ");
                String name = scanner.nextLine();
                System.out.println("Enter event date: ");
                String date = scanner.nextLine();
                System.out.println("Enter event location: ");
                String location = scanner.nextLine();
                if (managerServiceImplt != null) {
                    managerServiceImplt.addEvent(person.getId(), name, date, location);
                } else {
                    System.out.println("Service is not initialized.");
                }
                break;
            case 2:
                System.out.println("Enter event id: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter event name: ");
                name = scanner.nextLine();
                System.out.println("Enter event date: ");
                date = scanner.nextLine();
                System.out.println("Enter event location: ");
                location = scanner.nextLine();
                // Uncomment when update functionality is implemented
                // managerServiceImplt.updateEvent(id, name, date, location);
                break;
            case 3:
                System.out.println("Enter event id: ");
                id = scanner.nextInt();
                scanner.nextLine();
                managerServiceImplt.deleteEvent(id);
                break;
            case 4:
                // Uncomment when view functionality is implemented
                // managerServiceImplt.viewEvents();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }
}
