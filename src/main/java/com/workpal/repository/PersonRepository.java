package main.java.com.workpal.repository;

import java.util.List;

import main.java.com.workpal.model.Event;
import main.java.com.workpal.model.Person;

public interface PersonRepository {
public Person findByEmailAndPassword(String email, String password);
public void registerUser(String name, String email, String plainPassword, String role);
public void registerManager(String name, String email, String plainPassword, String role);

    
List<Person> getAllMembers();
List<Event> getAllEvents();
} 