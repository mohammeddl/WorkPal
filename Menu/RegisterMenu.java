package Menu;

import java.util.Scanner;

import main.java.com.workpal.service.AdminServiceImplt;
import main.java.com.workpal.service.PersonServiceImplt;

public class RegisterMenu {

    private static Scanner scanner = new Scanner(System.in);

    private static AdminServiceImplt adminServiceImplt;
    private static PersonServiceImplt personServiceImplt;

   public RegisterMenu(PersonServiceImplt personServiceImplt, AdminServiceImplt adminServiceImplt) {
        RegisterMenu.personServiceImplt = personServiceImplt;
        RegisterMenu.adminServiceImplt = adminServiceImplt;
    }


    public static void mainRegisterMenu() {
        while (true) {
            displayRegisterMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 3:
                    return; 
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Method to display the register menu
    public static void displayRegisterMenu() {
        System.out.println("Register Menu");
        System.out.println("1. Register as a new member/admin");
        System.out.println("3. Back to main menu");
        System.out.print("Choose an option: ");
    }

    // Method to handle the registration process
    private static void registerUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (member/admin): ");
        String role = scanner.nextLine().toLowerCase();

        switch (role) {
            case "member":
                personServiceImplt.registerMember(name, email, password, role);
                System.out.println("Member registered successfully.");
                break;
            case "admin":
                adminServiceImplt.addMember(name, email, password, role);
                System.out.println("Admin registered successfully.");
                break;
            default:
                System.out.println("Invalid role. Please enter 'member' or 'admin'.");
        }
    }
}
