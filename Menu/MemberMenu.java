package Menu;

import java.util.Scanner;

import main.java.com.workpal.model.Person;
import main.java.com.workpal.service.MemberServiceImplt;

public class MemberMenu {

    private static MemberServiceImplt memberServiceImplt;


    public MemberMenu(MemberServiceImplt memberServiceImplt) {
        MemberMenu.memberServiceImplt = memberServiceImplt;
    }

    public static void  mainMemberMenu(Person person) {
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
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    

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
        System.out.println("3. Exit");
    }

    public static void displayEditProfileMenu() {
        System.out.println("Edit Profile Menu:");
        System.out.println("1. Change Name");
        System.out.println("2. Change Email");
        System.out.println("3. Exit");
    }

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

    
}
