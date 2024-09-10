package Menu;
import java.util.Scanner;

public class MangerMenu {

    private static Scanner scanner = new Scanner(System.in);
    public static void mainManagerMenu() {
        while (true) {
            displayManagerMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    // manageEvents();
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

    // Method to display the register menu
    public static void displayManagerMenu() {
        System.out.println("1. Manage Events");
        System.out.println("2. Manage Spaces");
        System.out.println("3. Manage Services");
        System.out.println("4. Manage Subscriptions");
        System.out.print("Choose an option: ");
    }

   
    public static void manageEvents() {
        System.out.println("Manage Events");
        System.out.println("1. Add Event");
        System.out.println("2. Update Event");
        System.out.println("3. Delete Event");
        System.out.println("4. View Events");
        System.out.println("5. Back to main menu");
        System.out.print("Choose an option: ");
    }

    public static void manageSpaces() {
        System.out.println("Manage Spaces");
        System.out.println("1. Add Space");
        System.out.println("2. Update Space");
        System.out.println("3. Delete Space");
        System.out.println("4. View Spaces");
        System.out.println("5. Back to main menu");
        System.out.print("Choose an option: ");
    }

    public static void manageServices() {
        System.out.println("Manage Services");
        System.out.println("1. Add Service");
        System.out.println("2. Update Service");
        System.out.println("3. Delete Service");
        System.out.println("4. View Services");
        System.out.println("5. Back to main menu");
        System.out.print("Choose an option: ");
    }

    
}
