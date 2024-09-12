package main.java.com.workpal.repository;

import main.java.com.workpal.model.Service;
import java.util.List;

import main.java.com.workpal.model.Event;

public interface ManagerRepository {
    void addEvent(int mangerId, String name, String date, String location);
    void deleteEvents(int managerId, int eventId);
    List<Event> displayEventsManager(int managerId);
    void updateEvent(int eventId, int managerId, String name, String date, String location);
    

    //services

    void addService(int mangerId, String food);
    void deleteService(int managerId, int serviceId);
    void updateService(int serviceId, int managerId, String food);
    List<Service> displayServicesManager(int managerId);
}
