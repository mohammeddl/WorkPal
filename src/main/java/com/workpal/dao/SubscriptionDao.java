package main.java.com.workpal.dao;
import java.util.List;

import main.java.com.workpal.model.Subscription;

public interface SubscriptionDao {
    
    public void addSubscription(int managerId, int spaceId, int serviceId, int eventId, String dateStart, String dateEnd, int price);
    public void updateSubscription(int subscriptionId, int managerId, int spaceId, int serviceId, int eventId, String dateStart, String dateEnd, int price);
    public void deleteSubscription(int subscriptionId);
    List<Subscription> viewSubscription();
}
