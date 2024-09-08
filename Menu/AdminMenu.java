package Menu;

import java.util.Scanner;

import main.java.com.workpal.service.AdminService;


public class AdminMenu {
    public static void displayAdminMenu(AdminService adminService) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Member");
            System.out.println("2. Delete Member");
            System.out.println("3. Exit");

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
                    adminService.addPerson(name, email, password);
                    break;
                case 2:
                    System.out.println("Enter member ID to delete: ");
                    int id = scanner.nextInt();
                    adminService.deletePerson(id);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}