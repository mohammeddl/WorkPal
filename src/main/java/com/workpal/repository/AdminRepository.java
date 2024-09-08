package main.java.com.workpal.repository;



import main.java.com.workpal.model.Person;


public interface AdminRepository {
    void addPerson(Person person);  
    void deletePerson(int id);  
}
