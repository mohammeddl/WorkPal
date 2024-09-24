package main.java.com.workpal.service;

import main.java.com.workpal.model.Event;

import main.java.com.workpal.model.Service;
import main.java.com.workpal.model.Space;

import java.util.List;


public interface ManagerService {
    
    void addEvent(int mangerId, String name, String date, String location);
    void deleteEvent(int managerId, int eventId);
    List<Event> displayEventsManager(int managerId);
    void updateEvent(int eventId, int managerId, String name, String date, String location);


    void addService(int mangerId, String food );
    void deleteService(int managerId, int serviceId);
    void updateService(int serviceId, int managerId, String food);
    List<Service> displayServicesManager(int managerId);


    void addSpace(int mangerId, String type, String date, String status);
    void deleteSpace(int managerId, int spaceId);
    void updateSpace(int spaceId, int managerId, String type, String date, String status);
    List<Space> displaySpacesManager(int managerId);

    
}
