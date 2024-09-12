package main.java.com.workpal.model;

public class Service {

    private int serviceId;
    private int managerId;
    private String food;

    public Service(int serviceId, int managerId, String food) {
        this.serviceId = serviceId;
        this.managerId = managerId;
        this.food = food;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
