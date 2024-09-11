package main.java.com.workpal.dao;

public interface ManagerDao {

    void addEvent(int mangerId, String name, String date, String location);
    void deleteEvents(int id);
    // void updateEvents(String name, String date, String description);
    // void manageSpaces();
    // void manageServices();
    // void manageSubscriptions();
}
