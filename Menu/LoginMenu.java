package Menu;

import java.util.Scanner;

import main.java.com.workpal.model.Person;
import main.java.com.workpal.repository.PersonRepositoryImplt;
import main.java.com.workpal.service.AdminServiceImplt;
import main.java.com.workpal.service.FavoriteServiceImplt;
import main.java.com.workpal.service.ManagerServiceImplt;
import main.java.com.workpal.service.MemberServiceImplt;
import main.java.com.workpal.service.ReservationServiceImplt;
import main.java.com.workpal.service.SubscriptionServiceImplt;

public class LoginMenu {

    private static PersonRepositoryImplt personRepositoryImplt;
    private static AdminServiceImplt adminServiceImplt;
    private static MemberServiceImplt memberServiceImplt;
    private static ManagerServiceImplt managerServiceImplt;
    private static SubscriptionServiceImplt subscriptionServiceImplt;
    private static ReservationServiceImplt reservationServiceImplt;
    private static FavoriteServiceImplt favoriteServiceImplt;

    public LoginMenu(PersonRepositoryImplt personRepositoryImplt, AdminServiceImplt adminServiceImplt,
                     MemberServiceImplt memberServiceImplt, ManagerServiceImplt managerServiceImplt, SubscriptionServiceImplt subscriptionServiceImplt, ReservationServiceImplt reservationServiceImplt, FavoriteServiceImplt favoriteServiceImplt) {
        LoginMenu.personRepositoryImplt = personRepositoryImplt;
        LoginMenu.adminServiceImplt = adminServiceImplt;
        LoginMenu.memberServiceImplt = memberServiceImplt;
        LoginMenu.managerServiceImplt = managerServiceImplt;
        LoginMenu.subscriptionServiceImplt = subscriptionServiceImplt;
        LoginMenu.reservationServiceImplt = reservationServiceImplt;
        LoginMenu.favoriteServiceImplt = favoriteServiceImplt;
    }

    public static void displayLoginMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        Person person = personRepositoryImplt.findByEmailAndPassword(email, password);

        if (person != null) {
            System.out.println("Welcome " + person.getName());
            if (person.getRole().equals("admin")) {
                AdminMenu.displayAdminMenu(adminServiceImplt);
            } else if (person.getRole().equals("member")) {
                MemberMenu memberMenu = new MemberMenu(memberServiceImplt, reservationServiceImplt, favoriteServiceImplt);
                memberMenu.mainMemberMenu(person);
            } else if (person.getRole().equals("manager")) {
                ManagerMenu managerMenu = new ManagerMenu(managerServiceImplt, subscriptionServiceImplt);
                managerMenu.mainManagerMenu(person);
            } else {
                System.out.println("You are not authorized to manage members.");
            }
        } else {
            System.out.println("Invalid email or password!");
        }
    }
}
