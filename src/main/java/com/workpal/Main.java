package main.java.com.workpal;

import Menu.LoginMenu;
import Menu.RegisterMenu;
import main.java.com.workpal.dao.FavoriteDaoImplt;
import main.java.com.workpal.dao.ManagerDaoImplt;
import main.java.com.workpal.dao.MemberDaoImplt;
import main.java.com.workpal.dao.PersonDaoImplt;
import main.java.com.workpal.dao.ReservationDaoImplt;
import main.java.com.workpal.dao.SubscriptionDaoImplt;
import main.java.com.workpal.repository.AdminRepositoryImplt;
import main.java.com.workpal.repository.FavoriteRepositoryImplt;
import main.java.com.workpal.repository.ManagerRepositoryImplt;
import main.java.com.workpal.repository.MemberRepositoryImplt;
import main.java.com.workpal.repository.PersonRepositoryImplt;
import main.java.com.workpal.repository.ReservationRepositoryImplt;
import main.java.com.workpal.repository.SubscriptionRepositoryImplt;
// import main.java.com.workpal.service.AdminServiceImplt;
import main.java.com.workpal.service.AdminServiceImplt;
import main.java.com.workpal.service.FavoriteServiceImplt;
import main.java.com.workpal.service.ManagerServiceImplt;
import main.java.com.workpal.service.MemberServiceImplt;
import main.java.com.workpal.service.PersonServiceImplt;
import main.java.com.workpal.service.ReservationServiceImplt;
import main.java.com.workpal.service.SubscriptionServiceImplt;


public class Main {
    

    
    public static void main(String[] args){
        PersonDaoImplt personDao = new PersonDaoImplt();
        MemberDaoImplt memberDao = new MemberDaoImplt();
        ManagerDaoImplt managerDao = new ManagerDaoImplt();
        SubscriptionDaoImplt subscriptionDao = new SubscriptionDaoImplt();
        ReservationDaoImplt reservationDao = new ReservationDaoImplt();
        FavoriteDaoImplt favoriteDao = new FavoriteDaoImplt();

        PersonRepositoryImplt personRepository = new PersonRepositoryImplt(personDao);
        AdminRepositoryImplt adminRepositoryImplt = new AdminRepositoryImplt(personDao);
        MemberRepositoryImplt memberRepositoryImplt = new MemberRepositoryImplt(memberDao);
        ManagerRepositoryImplt managerRepositoryImplt = new ManagerRepositoryImplt(managerDao);
        SubscriptionRepositoryImplt subscriptionRepositoryImplt = new SubscriptionRepositoryImplt(subscriptionDao);
        ReservationRepositoryImplt reservationRepositoryImplt = new ReservationRepositoryImplt(reservationDao);
        FavoriteRepositoryImplt favoriteRepositoryImplt = new FavoriteRepositoryImplt(favoriteDao);
        
        AdminServiceImplt adminServiceImplt = new AdminServiceImplt(adminRepositoryImplt);
        MemberServiceImplt memberServiceImplt = new MemberServiceImplt(memberRepositoryImplt);
        PersonServiceImplt personServiceImplt = new PersonServiceImplt(personRepository);
        ManagerServiceImplt managerServiceImplt = new ManagerServiceImplt(managerRepositoryImplt);
        SubscriptionServiceImplt subscriptionServiceImplt = new SubscriptionServiceImplt(subscriptionRepositoryImplt);
        ReservationServiceImplt reservationServiceImplt = new ReservationServiceImplt(reservationRepositoryImplt);
        FavoriteServiceImplt favoriteServiceImplt = new FavoriteServiceImplt(favoriteRepositoryImplt);


        new LoginMenu(personRepository, adminServiceImplt, memberServiceImplt, managerServiceImplt, subscriptionServiceImplt, reservationServiceImplt, favoriteServiceImplt);
        new RegisterMenu(personServiceImplt, adminServiceImplt);

        RegisterMenu.mainRegisterMenu();
        LoginMenu.displayLoginMenu();
    }
}


