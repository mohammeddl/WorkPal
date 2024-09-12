package main.java.com.workpal.repository;

import main.java.com.workpal.dao.ManagerDaoImplt;
import main.java.com.workpal.model.Event;
import main.java.com.workpal.model.Service;
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


    //services

    public void addService(int mangerId, String food) {
        managerDao.addService(mangerId, food);
    }

    public void deleteService(int managerId, int serviceId) {
        managerDao.deleteService(managerId, serviceId);
    }

    public void updateService(int serviceId, int managerId, String food) {
        managerDao.updateService(serviceId, managerId, food);
    }

    public List<Service> displayServicesManager(int managerId) {
        return managerDao.displayServicesManager(managerId);
    }

}
