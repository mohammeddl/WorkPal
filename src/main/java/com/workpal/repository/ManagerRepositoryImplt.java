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

    public void deleteEvents(int id) {
        managerDao.deleteEvents(id);
    }

    public List<Event> displayEventsManager(int managerId) {
        return managerDao.displayEventsManager(managerId);
    }

}
