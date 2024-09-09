package main.java.com.workpal.dao;



import main.java.com.workpal.model.Person;

public interface PersonDao {
    void saveMember(String name, String password, String email, String role);
    void deleteById(int id);
    Person login(String email, String password);
}
