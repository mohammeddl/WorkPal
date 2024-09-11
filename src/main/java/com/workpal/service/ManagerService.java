package main.java.com.workpal.service;

import main.java.com.workpal.model.Event; 
import java.util.List;


public interface ManagerService {
    void addEvent(int mangerId, String name, String date, String location);
    void deleteEvent(int id);
    List<Event> displayEventsManager(int managerId);



    
}
