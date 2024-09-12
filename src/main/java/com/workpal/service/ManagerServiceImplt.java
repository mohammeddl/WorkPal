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

    public void deleteEvent(int managerId, int eventId) {
        managerRepositoryImplt.deleteEvents(managerId, eventId);
        System.out.println("Event deleted successfully.");
    }

    public List<Event> displayEventsManager(int managerId) {
        return managerRepositoryImplt.displayEventsManager(managerId);
       
    }

    public void updateEvent(int eventId, int managerId, String name, String date, String location) {
        managerRepositoryImplt.updateEvent(eventId, managerId, name, date, location);
        System.out.println("Event updated successfully.");
    }
}
