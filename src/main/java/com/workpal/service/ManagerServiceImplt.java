package main.java.com.workpal.service;

import main.java.com.workpal.model.Event;
import main.java.com.workpal.repository.ManagerRepositoryImplt;

import main.java.com.workpal.model.Service;
import main.java.com.workpal.model.Space;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


import java.util.List;

public class ManagerServiceImplt implements ManagerService {

    private ManagerRepositoryImplt managerRepositoryImplt;

    public ManagerServiceImplt(ManagerRepositoryImplt managerRepositoryImplt) {
        this.managerRepositoryImplt = managerRepositoryImplt;
    }

    //method for validating date
    private boolean isValidDate(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


    public void addEvent(int mangerId, String name, String date, String location) {
        if(isValidDate(date)){
        managerRepositoryImplt.addEvent(mangerId, name, date, location);
        System.out.println("Event added successfully.");
    }else{
        System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
    }
    }

    public void deleteEvent(int managerId, int eventId) {
        managerRepositoryImplt.deleteEvents(managerId, eventId);
        System.out.println("Event deleted successfully.");
    }

    public List<Event> displayEventsManager(int managerId) {
        return managerRepositoryImplt.displayEventsManager(managerId);
       
    }

    public void updateEvent(int eventId, int managerId, String name, String date, String location) {
        if(isValidDate(date)){
        managerRepositoryImplt.updateEvent(eventId, managerId, name, date, location);
        System.out.println("Event updated successfully.");
    }else{
        System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
    }
    }

//services

    public void addService(int mangerId, String food) {
        managerRepositoryImplt.addService(mangerId, food);
        System.out.println("Service added successfully.");
    }

    public void deleteService(int managerId, int serviceId) {
        managerRepositoryImplt.deleteService(managerId, serviceId);
        System.out.println("Service deleted successfully.");
    }


    public void updateService(int serviceId, int managerId, String food) {
        managerRepositoryImplt.updateService(serviceId, managerId, food);
        System.out.println("Service updated successfully.");
    }

    public List<Service> displayServicesManager(int managerId) {
        return managerRepositoryImplt.displayServicesManager(managerId);
    }


    //spaces

    public void addSpace(int mangerId, String type, String date, String status) {
        if(isValidDate(date)){
        managerRepositoryImplt.addSpace(mangerId, type, date, status);
        System.out.println("Space added successfully.");
        }else{
            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
        }
    }

    public void deleteSpace(int managerId, int spaceId) {
        managerRepositoryImplt.deleteSpace(managerId, spaceId);
        System.out.println("Space deleted successfully.");
    }

    public void updateSpace(int spaceId, int managerId, String type, String date, String status) {
        if(isValidDate(date)){
        managerRepositoryImplt.updateSpace(spaceId, managerId, type, date, status);
        System.out.println("Space updated successfully.");
        }else{
            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
        }
    }

    public List<Space> displaySpacesManager(int managerId) {
        return managerRepositoryImplt.displaySpacesManager(managerId);
    }
    


}
