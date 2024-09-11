package main.java.com.workpal.dao;



import main.java.com.workpal.model.Person;

public interface PersonDao {
    void saveMember(String name, String password, String email, String role);
    void deleteById(int id);
    Person login(String email, String password);
    void getAllMembersAndManagers();
    void registerUser(String name, String email, String plainPassword, String role);
    void registerManager(String name, String email, String plainPassword, String role);
}
