package main.java.com.workpal.service;

import main.java.com.workpal.model.Event;
import main.java.com.workpal.model.Person;

import java.util.List;

public interface PersonService {
    void registerMember(String name, String email, String plainPassword, String role);
    void registerManager(String name, String email, String plainPassword, String role);

    List<Person> getAllMembers();
    List<Event> getAllEvents();
}
