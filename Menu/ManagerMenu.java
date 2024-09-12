package Menu;

import java.util.Scanner;

import main.java.com.workpal.model.Event;
import main.java.com.workpal.model.Person;
import main.java.com.workpal.service.ManagerServiceImplt;

import main.java.com.workpal.model.Service;
import java.util.List;

public class ManagerMenu {

    private Scanner scanner = new Scanner(System.in); 
    private ManagerServiceImplt managerServiceImplt; 

    
    public ManagerMenu(ManagerServiceImplt managerServiceImplt) {
        this.managerServiceImplt = managerServiceImplt; 
    }

    public void mainManagerMenu(Person person) {

        while (true) {
            displayManagerMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    manageEvents(person); 
                    break;
                case 2:
                    // manageSpaces();
                    break;
                case 3:
                managerServices(person);
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


    public void managerServices(Person person) {
        System.out.println("Manage Services");
        System.out.println("1. Add Service");
        System.out.println("2. Update Service");
        System.out.println("3. Delete Service");
        System.out.println("4. View Services");
        System.out.println("5. Back to main menu");
        System.out.print("Choose an option: ");

        
            int choice = scanner.nextInt();
            scanner.nextLine();
                
            switch (choice) {
                case 1:
                    addService(person);
                    break;
                case 2:
                    updateService(person);
                    break;
                case 3:
                    deleteService(person);
                    break;
                case 4:
                    displayServices(person.getId());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
    }

    private void addService(Person person) {
       System.out.println("Enter Name of your food: ");
        String food = scanner.nextLine();
        if (managerServiceImplt != null) {
            System.out.println("this is your name "+ food);
            managerServiceImplt.addService(person.getId(), food);
        } else {
            System.out.println("Service is not initialized.");
        }
    }

    private void deleteService(Person person) {
        System.out.println("Enter Service ID: ");
        int serviceId = scanner.nextInt();
        if (managerServiceImplt != null) {
            managerServiceImplt.deleteService(person.getId(), serviceId);
        } else {
            System.out.println("Service is not initialized.");
        }
    }


    private void updateService(Person person) {
        System.out.println("Enter Service ID: ");
        int serviceId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Service name: ");
        String name = scanner.nextLine();
        if (managerServiceImplt != null) {
            managerServiceImplt.updateService(serviceId, person.getId(), name);
        } else {
            System.out.println("Service is not initialized.");
        }

    }

    private void displayServices(int managerId) {
        List<Service> services = managerServiceImplt.displayServicesManager(managerId);
        if (services.isEmpty()) {
            System.out.println("No services found.");
        } else {
            System.out.println("Service List:");
            for (Service service : services) {
                System.out.println("ID: " + service.getServiceId() +
                                ", Name: " + service.getFood() +
                                ", Manager ID: " + service.getManagerId());
            }
        }
    }
}


