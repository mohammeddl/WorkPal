package main.java.com.workpal.repository;

public interface ManagerRepository {
    void addEvent(int mangerId, String name, String date, String location);
    void deleteEvents(int id);
    // void updateEvents(String name, String date, String description);
    
}
