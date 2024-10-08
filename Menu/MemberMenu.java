package Menu;

import java.util.Scanner;

import main.java.com.workpal.model.FavoriteSpace;
import main.java.com.workpal.model.Person;
import main.java.com.workpal.model.Reservation;
import main.java.com.workpal.model.Space;
import main.java.com.workpal.service.FavoriteServiceImplt;
import main.java.com.workpal.service.MemberServiceImplt;
import main.java.com.workpal.service.ReservationServiceImplt;
import java.util.List;

public class MemberMenu {

    private static MemberServiceImplt memberServiceImplt;
    private static ReservationServiceImplt reservationServiceImplt;
    private static FavoriteServiceImplt favoriteServiceImplt;
    private static Scanner scanner = new Scanner(System.in);


    public MemberMenu(MemberServiceImplt memberServiceImplt, ReservationServiceImplt reservationServiceImplt, FavoriteServiceImplt favoriteServiceImplt) {
        MemberMenu.memberServiceImplt = memberServiceImplt;
        MemberMenu.reservationServiceImplt = reservationServiceImplt;
        MemberMenu.favoriteServiceImplt = favoriteServiceImplt;
    }

    public void  mainMemberMenu(Person person) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMemberMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    modifyProfile(scanner, person);
                    break;
                case 3:
                    break;
                case 4:
                reserveSpace(person);
                    break;
                case 5:
                viewReservations(person);
                    break;
                case 6:
                addFavoriteSpace(person);
                    break;
                case 7:
                viewFavoriteSpaces(person);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    
    //modify profile
    private static void modifyProfile(Scanner scanner, Person person) {
        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new email: ");
        String email = scanner.nextLine();
        memberServiceImplt.modifyProfile(person.getId(), name, email);
    }

    public static void displayMemberMenu() {
        System.out.println("Member Menu:");
        System.out.println("1. View Profile");
        System.out.println("2. Edit Profile");
        System.out.println("3. Search for Spaces");
        System.out.println("4. Reserve a Space");
        System.out.println("5. View Your Reservations");
        System.out.println("6. Add Favorite Space");
        System.out.println("7. View Favorite Spaces");
        System.out.println("8. Exit");
    }



    public static void displayEditProfileMenu() {
        System.out.println("Edit Profile Menu:");
        System.out.println("1. Change Name");
        System.out.println("2. Change Email");
        System.out.println("3. Exit");
    }

    // menu profile
    public static void displayViewProfileMenu() {
        System.out.println("View Profile Menu:");
        System.out.println("1. View Name");
        System.out.println("2. View Email");
        System.out.println("3. View Password");
        System.out.println("4. Exit");
    }

    public static void displayEditProfileNameMenu() {
        System.out.println("Enter new name: ");
    }





    // reservation

    //add reservation
    private static void reserveSpace(Person person) {
        displayAllSpaces();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter space id: ");
            int spaceId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter date start: ");
            String dateStart = scanner.nextLine();
            System.out.println("Enter date end: ");
            String dateEnd = scanner.nextLine();
            
            reservationServiceImplt.addReservation(person.getId(), spaceId, dateStart, dateEnd);
        }catch (Exception e){
            System.out.println("Invalid input.");
        }
    }

    // view reservations
    public static void viewReservations(Person person) {
        List<Reservation> reservations = reservationServiceImplt.getReservationsByMember(person.getId());
        if(reservations.isEmpty()){
            System.out.println("No reservations found.");
        }else{
            reservations.stream().forEach(reservation -> {
                System.out.println("Reservation ID: " + reservation.getReservationId());
                System.out.println("Space ID: " + reservation.getSpaceId());
                System.out.println("Start Date: " + reservation.getReservationStartDate());
                System.out.println("End Date: " + reservation.getReservationEndDate());
                System.out.println("Status: " + reservation.getStatus());
                System.out.println("Type: " + reservation.getType());
            });
        }
    }

    // view all spaces
    public static void displayAllSpaces() {
       List<Space> spaces = memberServiceImplt.viewAllSpaces();
         if(spaces.isEmpty()){
              System.out.println("No spaces found.");
            }else{
                spaces.stream().forEach(space -> {
                    System.out.println("Space ID: " + space.getSpaceId());
                    System.out.println("Type: " + space.getType());
                    System.out.println("Date: " + space.getDate());
                    System.out.println("Status: " + space.getStatus());
                });
            }
    }


    // favorite space

    // add favorite space
    private static void addFavoriteSpace(Person person) {
            displayAllSpaces();
            System.out.println("Enter space id: ");
            int spaceId = scanner.nextInt();
            scanner.nextLine();
            favoriteServiceImplt.addFavorite(person.getId(), spaceId);
    }

    // view favorite spaces

    public static void viewFavoriteSpaces(Person person) {
        List<FavoriteSpace> spaces = favoriteServiceImplt.displayFavorites(person.getId());
        if(spaces.isEmpty()){
            System.out.println("No favorite spaces found.");
        }else{
            spaces.stream().forEach(space -> {
                System.out.print("Favorite ID: " + space.getFavoriteId());
                System.out.print(" Space ID: " + space.getSpaceId());
                    System.out.print(" Date Added: " + space.getDateAdded()+"\n");
            });
        }
    }

}
