package main.java.com.workpal.model;

public class Event {
    private int eventId;
    private String description;

    public Event(int eventId, String description) {
        this.eventId = eventId;
        this.description = description;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
