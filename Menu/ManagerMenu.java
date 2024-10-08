package Menu;

import java.util.Scanner;
import main.java.com.workpal.model.Subscription;
import main.java.com.workpal.model.Event;
import main.java.com.workpal.model.Person;
import main.java.com.workpal.service.ManagerServiceImplt;
import main.java.com.workpal.service.SubscriptionServiceImplt;
import main.java.com.workpal.model.Service;
import main.java.com.workpal.model.Space;

import java.util.List;

public class ManagerMenu {

    private Scanner scanner = new Scanner(System.in); 
    private ManagerServiceImplt managerServiceImplt; 
    private SubscriptionServiceImplt subscriptionServiceImplt;

    
    public ManagerMenu(ManagerServiceImplt managerServiceImplt, SubscriptionServiceImplt subscriptionServiceImplt) {
        this.managerServiceImplt = managerServiceImplt; 
        this.subscriptionServiceImplt = subscriptionServiceImplt;
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
                    manageSpaces(person);
                    break;
                case 3:
                    managerServices(person);
                    break;
                case 4:
                    manageSubsciptions(person);
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
                System.out.println("Enter event date (yyyy-MM-dd): ");
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
//update event
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
//delete event
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



// Method to manage services menu
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

    // Method to add service
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

    // Method to delete service
    private void deleteService(Person person) {
        System.out.println("Enter Service ID: ");
        int serviceId = scanner.nextInt();
        if (managerServiceImplt != null) {
            managerServiceImplt.deleteService(person.getId(), serviceId);
        } else {
            System.out.println("Service is not initialized.");
        }
    }
 // Method to update service
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
// Method to display all services
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


// Method to manage spaces menu
    public void manageSpaces(Person person) {
        System.out.println("Manage Spaces");
        System.out.println("1. Add Space");
        System.out.println("2. Update Space");
        System.out.println("3. Delete Space");
        System.out.println("4. View Spaces");
        System.out.println("5. Back to main menu");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addSpace(person);
                break;
            case 2:
                updateSpace(person);
                break;
            case 3:
                deleteSpace(person);
                break;
            case 4:
                displaySpaces(person.getId());
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    // Method to add space
    private  void addSpace(Person person) {
        System.out.println("Enter type of space(workspace/meeting room): ");
        String type = scanner.nextLine();
        System.out.println("Enter space Status(empty OR not): ");
        String status = scanner.nextLine();
        System.out.println("Enter space date (yyyy-MM-dd): ");
        String date = scanner.nextLine();
        if (managerServiceImplt != null) {
            managerServiceImplt.addSpace(person.getId(), type, date, status);
        } else {
            System.out.println("Service is not initialized.");
        }
    }

    // Method to delete space
    private void deleteSpace(Person person) {
        displaySpaces(person.getId());
        System.out.println("Enter Space ID: ");
        int spaceId = scanner.nextInt();
        if (managerServiceImplt != null) {
            managerServiceImplt.deleteSpace(person.getId(), spaceId);
        } else {
            System.out.println("Service is not initialized.");
        }
    }

    // Method to update space
    private void updateSpace(Person person) {
        displaySpaces(person.getId());
        System.out.println("Enter Space ID: ");
        int spaceId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Space type: ");
        String type = scanner.nextLine();
        System.out.println("Enter Space date: ");
        String date = scanner.nextLine();
        System.out.println("Enter Space status: ");
        String status = scanner.nextLine();
        if (managerServiceImplt != null) {
            managerServiceImplt.updateSpace(spaceId, person.getId(), type, date, status);
        } else {
            System.out.println("Service is not initialized.");
        }
    }

    // Method to display all spaces
    private void displaySpaces(int managerId) {
        List<Space> spaces = managerServiceImplt.displaySpacesManager(managerId);
        if (spaces.isEmpty()) {
            System.out.println("No spaces found.");
        } else {
            System.out.println("Space List:");
            for (Space space : spaces) {
                System.out.println("ID: " + space.getSpaceId() +
                                ", Type: " + space.getType() +
                                ", Date: " + space.getDate() +
                                ", Status: " + space.getStatus() +
                                ", Manager ID: " + space.getManagerId());
            }
        }
    }
    


    // Method to manage subscriptions
//menu for managing subscriptions
    public void manageSubsciptions(Person person) {
        System.out.println("Manage Subscriptions");
        System.out.println("1. Add Subscription");
        System.out.println("2. Update Subscription");
        System.out.println("3. Delete Subscription");
        System.out.println("4. View Subscriptions");
        System.out.println("5. Back to main menu");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addSubscription(person);
                break;
            case 2:
                updateSubscription(person);
                break;
            case 3:
                deleteSubscription(person);
                break;
            case 4:
                viewSubscription(person);
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }


    //subscription

    //method to add subscription
    private void addSubscription(Person person) {
        displaySpaces(person.getId());
        System.out.println("Enter space ID: ");
        int spaceId = scanner.nextInt();
        scanner.nextLine(); 
        displayServices(person.getId());
        System.out.println("Enter service ID: ");
        int serviceId = scanner.nextInt();
        scanner.nextLine();
        displayEvents(person.getId());
        System.out.println("Enter event ID: ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter start date (yyyy-MM-dd): ");
        String dateStart = scanner.nextLine();
        System.out.println("Enter end date (yyyy-MM-dd): ");
        String dateEnd = scanner.nextLine(); 
        System.out.println("Enter price: ");
        int price = scanner.nextInt();
        scanner.nextLine();  
        if (subscriptionServiceImplt != null) {
            subscriptionServiceImplt.addSubscription(person.getId(), spaceId, serviceId, eventId, dateStart, dateEnd, price);
        } else {
            System.out.println("Service is not initialized.");
        }
    }
    

//method to view subscription
    private void viewSubscription(Person person) {
        List<Subscription> subscriptions = subscriptionServiceImplt.viewSubscription();
        
        if (subscriptions.isEmpty()) {
            System.out.println("No subscriptions found.");
        } else {
            System.out.println("Subscription List:");
            subscriptions.stream()
                .filter(subscription -> subscription.getManagerId() == person.getId()) 
                .forEach(subscription -> System.out.println(
                    "ID: " + subscription.getSubscriptionId() +
                    ", Space ID: " + subscription.getSpaceId() +
                    ", Service ID: " + subscription.getServiceId() +
                    ", Event ID: " + subscription.getEventId() +
                    ", Start Date: " + subscription.getDateStart() +
                    ", End Date: " + subscription.getDateEnd() +
                    ", Price: " + subscription.getPrice()
                ));
        }
    }
    

//method to delete subscription
    private void deleteSubscription(Person person) {
        viewSubscription(person);
        System.out.println("Enter Subscription ID: ");
        int subscriptionId = scanner.nextInt();
        if (subscriptionServiceImplt != null) {
            subscriptionServiceImplt.deleteSubscription(subscriptionId);
        } else {
            System.out.println("Service is not initialized.");
        }
    }

    //method to update subscription
    private void updateSubscription(Person person) {
        System.out.println("Enter Subscription ID: ");
        int subscriptionId = scanner.nextInt();
        scanner.nextLine();
        displaySpaces(person.getId());
        System.out.println("Enter space ID: ");
        int spaceId = scanner.nextInt();
        scanner.nextLine();
        displayServices(person.getId());
        System.out.println("Enter service ID: ");
        int serviceId = scanner.nextInt();
        scanner.nextLine();
        displayEvents(person.getId());
        System.out.println("Enter event ID: ");
        int eventId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter start date (yyyy-MM-dd): ");
        String dateStart = scanner.nextLine();
        System.out.println("Enter end date (yyyy-MM-dd): ");
        String dateEnd = scanner.nextLine();
        System.out.println("Enter price: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        if (subscriptionServiceImplt != null) {
            subscriptionServiceImplt.updateSubscription(subscriptionId, person.getId(), spaceId, serviceId, eventId, dateStart, dateEnd, price);
        } else {
            System.out.println("Service is not initialized.");
        }
    }


}


