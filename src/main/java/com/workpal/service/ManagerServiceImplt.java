package main.java.com.workpal.service;

import main.java.com.workpal.model.Event;
import main.java.com.workpal.repository.ManagerRepositoryImplt;
import java.util.List;

public class ManagerServiceImplt implements ManagerService {

    private ManagerRepositoryImplt managerRepositoryImplt;

    public ManagerServiceImplt(ManagerRepositoryImplt managerRepositoryImplt) {
        this.managerRepositoryImplt = managerRepositoryImplt;
    }



    public void addEvent(int mangerId, String name, String date, String location) {
        managerRepositoryImplt.addEvent(mangerId, name, date, location);
        System.out.println("Event added successfully.");
    }

    public void deleteEvent(int id) {
        System.out.println("Event deleted successfully.");
    }

    public List<Event> displayEventsManager(int managerId) {
        return managerRepositoryImplt.displayEventsManager(managerId);
       
    }
}
