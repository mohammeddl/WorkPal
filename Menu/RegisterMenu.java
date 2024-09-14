package Menu;

import java.util.Scanner;

import main.java.com.workpal.model.Member;
import main.java.com.workpal.service.AdminServiceImplt;
import main.java.com.workpal.service.MemberServiceImplt;
import main.java.com.workpal.service.PersonServiceImplt;

public class RegisterMenu {

    private static Scanner scanner = new Scanner(System.in);

    private static AdminServiceImplt adminServiceImplt;
    private static PersonServiceImplt personServiceImplt;
    private static MemberServiceImplt memberServiceImplt;

   public RegisterMenu(PersonServiceImplt personServiceImplt, AdminServiceImplt adminServiceImplt, MemberServiceImplt memberServiceImplt) {
        RegisterMenu.personServiceImplt = personServiceImplt;
        RegisterMenu.adminServiceImplt = adminServiceImplt;
        RegisterMenu.memberServiceImplt = memberServiceImplt;
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
                case 2:
                    resetPassword();
                    System.out.println("Password reset successful.");
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
        System.out.println("2. Reset password");
        System.out.println("3. Back to login menu");
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
        System.out.print("Enter role (member/manager): ");
        String role = scanner.nextLine().toLowerCase();

        switch (role) {
            case "member":
                personServiceImplt.registerMember(name, email, password, role);
                break;
            case "manager":
                personServiceImplt.registerManager(name, email, password, role);
                break;
            default:
                System.out.println("Invalid role. Please enter 'member' or 'admin'.");
        }
    }


    private static void resetPassword() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        memberServiceImplt.resetPassword(email);
        System.out.println("Temporary password sent to your email.");

    }




}
