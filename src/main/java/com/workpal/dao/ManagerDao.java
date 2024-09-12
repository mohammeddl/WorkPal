package main.java.com.workpal.dao;
import java.util.List;

import main.java.com.workpal.model.Event;

public interface ManagerDao {

    void addEvent(int mangerId, String name, String date, String location);
    void deleteEvents(int managerId, int eventId);
    List<Event> displayEventsManager(int managerId);
    void updateEvent(int eventId ,int managerId, String name, String date, String location);
}
