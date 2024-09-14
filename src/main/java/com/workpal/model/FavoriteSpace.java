package main.java.com.workpal.model;

public class FavoriteSpace {
    private int favoriteId;
    private int memberId;
    private int spaceId;
    private String dateAdded;

    public FavoriteSpace(int favoriteId, int memberId, int spaceId, String dateAdded) {
        this.favoriteId = favoriteId;
        this.memberId = memberId;
        this.spaceId = spaceId;
        this.dateAdded = dateAdded;
    }

    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    
}
