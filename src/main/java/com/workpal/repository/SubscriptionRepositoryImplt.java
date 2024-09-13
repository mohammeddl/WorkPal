package main.java.com.workpal.repository;

import java.util.List;
import main.java.com.workpal.dao.SubscriptionDaoImplt;
import main.java.com.workpal.model.Subscription;

public class SubscriptionRepositoryImplt implements SubscriptionRepository {

    private final SubscriptionDaoImplt subscriptionDao;

    public SubscriptionRepositoryImplt(SubscriptionDaoImplt subscriptionDao) {
        this.subscriptionDao = subscriptionDao;
    }

    public void addSubscription(int managerId, int spaceId, int serviceId, int eventId, String dateStart, String dateEnd, int price) {
        subscriptionDao.addSubscription(managerId, spaceId, serviceId, eventId, dateStart, dateEnd, price);
    }

    public void updateSubscription(int subscriptionId, int managerId, int spaceId, int serviceId, int eventId, String dateStart, String dateEnd, int price) {
        subscriptionDao.updateSubscription(subscriptionId, managerId, spaceId, serviceId, eventId, dateStart, dateEnd, price);
    }

    public void deleteSubscription(int subscriptionId) {
        subscriptionDao.deleteSubscription(subscriptionId);
    }

    public List<Subscription> viewSubscription() {
        return subscriptionDao.viewSubscription();
    }
    
}
