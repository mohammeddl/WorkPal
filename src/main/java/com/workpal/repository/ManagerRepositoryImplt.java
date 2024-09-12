package main.java.com.workpal.repository;

import main.java.com.workpal.dao.ManagerDaoImplt;
import main.java.com.workpal.model.Event;
import java.util.List;

public class ManagerRepositoryImplt implements ManagerRepository {

    private final ManagerDaoImplt managerDao;

    public ManagerRepositoryImplt(ManagerDaoImplt managerDao) {
        this.managerDao = managerDao;
    }

   public void addEvent(int mangerId, String name, String date, String location) {
        managerDao.addEvent(mangerId, name, date, location);
    }

    public void deleteEvents(int managerId, int eventId) {
        managerDao.deleteEvents(managerId, eventId);
    }

    public List<Event> displayEventsManager(int managerId) {
        return managerDao.displayEventsManager(managerId);
    }

    public void updateEvent(int eventId, int managerId, String name, String date, String location) {
        managerDao.updateEvent(eventId, managerId, name, date, location);
    }

}
