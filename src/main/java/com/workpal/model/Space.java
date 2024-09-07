package main.java.com.workpal.model;

public class Space {
    private int spaceId;
    private String type;

    public Space(int spaceId, String type) {
        this.spaceId = spaceId;
        this.type = type;
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


    
}
