package main.java.com.workpal.service;


import main.java.com.workpal.model.Subscription;
import main.java.com.workpal.repository.SubscriptionRepositoryImplt;

import java.util.List;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SubscriptionServiceImplt implements SubscriptionService {
    
    private SubscriptionRepositoryImplt subscriptionRepositoryImplt;

    public SubscriptionServiceImplt(SubscriptionRepositoryImplt subscriptionRepositoryImplt) {
        this.subscriptionRepositoryImplt = subscriptionRepositoryImplt;
    }
    
    public void addSubscription(int managerId, int spaceId, int serviceId, int eventId, String dateStart, String dateEnd, int price) {
        if(isValide(dateStart, dateEnd)){
            subscriptionRepositoryImplt.addSubscription(managerId, spaceId, serviceId, eventId, dateStart, dateEnd, price);
            System.out.println("Subscription added successfully.");
        }else{
            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
        }
    }


    public void updateSubscription(int subscriptionId, int managerId, int spaceId, int serviceId, int eventId, String dateStart, String dateEnd, int price) {
        subscriptionRepositoryImplt.updateSubscription(subscriptionId, managerId, spaceId, serviceId, eventId, dateStart, dateEnd, price);
    }

    public void deleteSubscription(int subscriptionId) {
        subscriptionRepositoryImplt.deleteSubscription(subscriptionId);
    }

    public List<Subscription> viewSubscription() {
        return subscriptionRepositoryImplt.viewSubscription();
    }
    
    private boolean isValide(String dateStart, String dateEnd) {
        try {
            LocalDate.parse(dateStart, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate.parse(dateEnd, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            return false;
        }
    }

    
}
