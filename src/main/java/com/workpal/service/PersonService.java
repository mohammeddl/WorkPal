package main.java.com.workpal.service;

public interface PersonService {
    void registerMember(String name, String email, String plainPassword, String role);
    void registerManager(String name, String email, String plainPassword, String role);
}
