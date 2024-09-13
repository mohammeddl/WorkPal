package main.java.com.workpal.dao;

import java.sql.Connection;
import main.java.com.workpal.config.DatabaseConnection;
import main.java.com.workpal.model.Subscription;

import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;


public class SubscriptionDaoImplt implements SubscriptionDao {
        
     
     private final Connection connection;

     public SubscriptionDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
     }

        public void addSubscription(int managerId, int spaceId, int serviceId, int eventId, String dateStart, String dateEnd, int price){
            String query = "INSERT INTO subscription (managerId, spaceId, serviceId, eventId, dateStart, dateEnd, price) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, managerId);
                preparedStatement.setInt(2, spaceId);
                preparedStatement.setInt(3, serviceId);
                preparedStatement.setInt(4, eventId);
                preparedStatement.setString(5, dateStart);
                preparedStatement.setString(6, dateEnd);
                preparedStatement.setInt(7, price);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
        }     
}

        public void updateSubscription(int subscriptionId, int managerId, int spaceId, int serviceId, int eventId, String dateStart, String dateEnd, int price){
            String query = "UPDATE subscription SET managerId = ?, spaceId = ?, serviceId = ?, eventId = ?, dateStart = ?, dateEnd = ?, price = ? WHERE subscriptionId = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, managerId);
                preparedStatement.setInt(2, spaceId);
                preparedStatement.setInt(3, serviceId);
                preparedStatement.setInt(4, eventId);
                preparedStatement.setString(5, dateStart);
                preparedStatement.setString(6, dateEnd);
                preparedStatement.setInt(7, price);
                preparedStatement.setInt(8, subscriptionId);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void deleteSubscription(int subscriptionId){
            String query = "DELETE FROM subscription WHERE subscriptionId = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, subscriptionId);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public List<Subscription> viewSubscription(){
            List<Subscription> subscriptions = new ArrayList<>();
            String req = "SELECT * FROM subscription";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(req);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Subscription subscription = new Subscription(
                            resultSet.getInt("subscriptionId"),
                            resultSet.getInt("managerId"),
                            resultSet.getInt("spaceId"),
                            resultSet.getInt("serviceId"),
                            resultSet.getInt("eventId"),
                            resultSet.getString("dateStart"),
                            resultSet.getString("dateEnd"),
                            resultSet.getInt("price")
                    );
                    subscriptions.add(subscription);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return subscriptions;
        }




}

