package main.java.com.workpal.dao;

import java.util.List;

import main.java.com.workpal.model.Reservation;

public interface ReservationDao {
    void addReservation(int memberId, int spaceId, String reservationStartDate, String reservationEndDate);
    List<Reservation> getReservationsByMember(int memberId);
}
