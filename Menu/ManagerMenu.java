package Menu;

import java.util.Scanner;

import main.java.com.workpal.model.Event;
import main.java.com.workpal.model.Person;
import main.java.com.workpal.service.ManagerServiceImplt;

import java.util.List;

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
                updateEvent(person.getId());
                break;
            case 3:
                deleteEvent(person.getId());
                break;
            case 4:
            displayEvents(person.getId());
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }


    //method for displaying all events
    private void displayEvents(int managerId) {
        List<Event> events = managerServiceImplt.displayEventsManager(managerId);
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            System.out.println("Event List:");
            for (Event event : events) {
                System.out.println("ID: " + event.getEventId() +
                                ", Name: " + event.getName() +
                                ", Date: " + event.getDate() +
                                ", Location: " + event.getLocation() +
                                ", Manager ID: " + event.getManagerId());
            }
        }
    }

    private void updateEvent(int managerId) {
        displayEvents(managerId);
        System.out.println("Enter event ID: ");
        int eventId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter event name: ");
        String name = scanner.nextLine();
        System.out.println("Enter event date: ");
        String date = scanner.nextLine();
        System.out.println("Enter event location: ");
        String location = scanner.nextLine();
        if (managerServiceImplt != null) {
            managerServiceImplt.updateEvent(eventId,managerId, name, date, location);
        } else {
            System.out.println("Service is not initialized.");
        }
    }

    private void deleteEvent(int managerId) {
        displayEvents(managerId);
        System.out.println("Enter event ID: ");
        int eventId = scanner.nextInt();
        if (managerServiceImplt != null) {
            managerServiceImplt.deleteEvent(managerId, eventId);
        } else {
            System.out.println("Service is not initialized.");
        }
    }
}


