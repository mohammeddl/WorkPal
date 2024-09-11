package main.java.com.workpal.service;

import main.java.com.workpal.repository.PersonRepositoryImplt;

public class PersonServiceImplt implements PersonService {
    private final PersonRepositoryImplt personRepository;

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
}
