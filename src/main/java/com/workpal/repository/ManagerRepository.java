package main.java.com.workpal.repository;

import java.util.List;

import main.java.com.workpal.model.Event;

public interface ManagerRepository {
    void addEvent(int mangerId, String name, String date, String location);
    void deleteEvents(int id);
    List<Event> displayEventsManager(int managerId);
    
}
