package main.java.com.workpal.service;

import java.util.List;

import main.java.com.workpal.model.Event;
import main.java.com.workpal.model.Person;
import main.java.com.workpal.repository.PersonRepositoryImplt;

public class PersonServiceImplt implements PersonService {
    private final PersonRepositoryImplt personRepository;

    @Override
    public List<Person> getAllMembers() {
        return personRepository.getAllMembers();
    }

     public PersonServiceImplt(PersonRepositoryImplt personRepository) {
        this.personRepository = personRepository;
    }
    public void registerMember(String name, String email, String plainPassword, String role) {
        personRepository.registerUser(name, email, plainPassword, role);
        System.out.println("User registered successfully.");
    }

    public void registerManager(String name, String email, String plainPassword, String role) {
        personRepository.registerManager(name, email, plainPassword, role);
        System.out.println("User registered successfully.");
    }

    public List<Person> getAllUsers() {
        return personRepository.getAllMembers();
    }

    public List<Event> getAllEvents() {
        return personRepository.getAllEvents();
    }


}
