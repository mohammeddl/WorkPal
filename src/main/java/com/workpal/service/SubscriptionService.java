package main.java.com.workpal.service;
import java.util.List;
import main.java.com.workpal.model.Subscription;

public interface SubscriptionService {

    void addSubscription(int managerId, int spaceId, int serviceId, int eventId, String dateStart, String dateEnd, int price);
    void updateSubscription(int subscriptionId, int managerId, int spaceId, int serviceId, int eventId, String dateStart, String dateEnd, int price);
    void deleteSubscription(int subscriptionId);
    List<Subscription> viewSubscription();
    
}
