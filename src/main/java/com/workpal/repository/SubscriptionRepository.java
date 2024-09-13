package main.java.com.workpal.repository;

import java.util.List;
import main.java.com.workpal.model.Subscription;

public interface SubscriptionRepository {
    

    void addSubscription(int managerId, int spaceId, int serviceId, int eventId, String dateStart, String dateEnd, int price);
    void updateSubscription(int subscriptionId, int managerId, int spaceId, int serviceId, int eventId, String dateStart, String dateEnd, int price);
    void deleteSubscription(int subscriptionId);
    List<Subscription> viewSubscription();
}
