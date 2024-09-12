package main.java.com.workpal.service;

import main.java.com.workpal.model.Event; 
import java.util.List;


public interface ManagerService {
    void addEvent(int mangerId, String name, String date, String location);
    void deleteEvent(int managerId, int eventId);
    List<Event> displayEventsManager(int managerId);
    void updateEvent(int eventId, int managerId, String name, String date, String location);



    
}
