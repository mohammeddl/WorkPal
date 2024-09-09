package main.java.com.workpal.repository;





public interface AdminRepository {
    void addMember(String name, String email, String password, String role);  
    void deletePerson(int id);  
}
