package main.java.com.workpal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.java.com.workpal.config.DatabaseConnection;
import main.java.com.workpal.model.Reservation;

public class ReservationDaoImplt implements ReservationDao {

    private final Connection connection;

    public ReservationDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    
     public void addReservation(int memberId, int spaceId, String reservationStartDate, String reservationEndDate) {
        String query = "INSERT INTO reservation (spaceId, memberId, reservationStartDate, reservationEndDate, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, spaceId);
            preparedStatement.setInt(2, memberId);
            preparedStatement.setString(3, reservationStartDate);
            preparedStatement.setString(4, reservationEndDate);
            preparedStatement.setString(5, "pending");
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Reservation> getReservationsByMember(int memberId) {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT r.reservationId, r.spaceId, r.memberId, r.reservationStartDate, r.reservationEndDate, r.status, s.type " +
                       "FROM reservation r " +
                       "JOIN space s ON r.spaceId = s.spaceId " +
                       "WHERE r.memberId = ?";
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, memberId);
            ResultSet resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                Reservation reservation = new Reservation(
                        resultSet.getInt("reservationId"),
                        resultSet.getInt("spaceId"),
                        resultSet.getInt("memberId"),
                        resultSet.getString("reservationStartDate"),
                        resultSet.getString("reservationEndDate"),
                        resultSet.getString("status"),
                        resultSet.getString("type") 
                );
                reservations.add(reservation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservations;
    }
    
    
}
