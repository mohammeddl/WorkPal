package main.java.com.workpal.repository;

import main.java.com.workpal.model.Person;

public interface PersonRepository {
public Person findByEmailAndPassword(String email, String password);

    
} 