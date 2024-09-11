package main.java.com.workpal.dao;
import java.util.List;

import main.java.com.workpal.model.Event;

public interface ManagerDao {

    void addEvent(int mangerId, String name, String date, String location);
    void deleteEvents(int id);
    List<Event> displayEventsManager(int managerId);
}
