package main.java.com.workpal.model;

public class Event {
    private int eventId;
    private String name;
    private String date;
    private String location;
    private int managerId;

    public Event(int eventId, String name, String date, String location, int managerId) {
        this.eventId = eventId;
        this.name = name;
        this.date = date;
        this.location = location;
        this.managerId = managerId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }


    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }





    
}
