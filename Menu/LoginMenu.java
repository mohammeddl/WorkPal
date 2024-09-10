package Menu;

import java.util.Scanner;

import main.java.com.workpal.model.Person;

import main.java.com.workpal.repository.PersonRepositoryImplt;

import main.java.com.workpal.service.AdminServiceImplt;
import main.java.com.workpal.service.MemberServiceImplt;

public class LoginMenu {

    private static PersonRepositoryImplt personRepositoryImplt;
    private static AdminServiceImplt adminServiceImplt;
    private static MemberServiceImplt memberServiceImplt;
    

    public LoginMenu(PersonRepositoryImplt personRepositoryImplt, AdminServiceImplt adminServiceImplt, MemberServiceImplt memberServiceImplt) {
        LoginMenu.personRepositoryImplt = personRepositoryImplt;
        LoginMenu.adminServiceImplt = adminServiceImplt;
        LoginMenu.memberServiceImplt = memberServiceImplt;
    }

    public static void displayLoginMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        Person  person = personRepositoryImplt.findByEmailAndPassword(email, password);

        if (person != null) {
            System.out.println("Welcome " + person.getName());
            if (person.getRole().equals("admin")) {
                AdminMenu.displayAdminMenu(adminServiceImplt);
            } else if ( person.getRole().equals("member")) {
                MemberMenu.mainMemberMenu(person);
            } else {
                System.out.println("You are not authorized to manage members.");
            }
        } else {
            System.out.println("Invalid email or password!");
        }
    }
}
