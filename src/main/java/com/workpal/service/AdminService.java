package main.java.com.workpal.service;


public interface AdminService {

      void addMember(String name , String email , String password, String role);
      void deletePerson(int id); 
      void displayAllMembers();
} 