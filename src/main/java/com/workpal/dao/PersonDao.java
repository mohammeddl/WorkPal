package main.java.com.workpal.dao;

import main.java.com.workpal.model.Person;

public interface PersonDao {
    void save(Person person);
    void deleteById(int id);
    void login(String email, String password);
}
