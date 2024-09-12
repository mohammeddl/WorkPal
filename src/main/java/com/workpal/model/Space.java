package main.java.com.workpal.model;

public class Space {
    private int spaceId;
    private String type;
    private String date;
    private String status;
    private int managerId;

    public Space(int spaceId, String type, String date, String status, int managerId) {
        this.spaceId = spaceId;
        this.type = type;
        this.date = date;
        this.status = status;
        this.managerId = managerId;

    }

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    
}
