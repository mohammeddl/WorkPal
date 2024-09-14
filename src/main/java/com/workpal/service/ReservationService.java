package main.java.com.workpal.service;

import main.java.com.workpal.model.Reservation;
import java.util.List;

public interface ReservationService {

    void addReservation(int memberId, int spaceId, String reservationStartDate, String reservationEndDate);

    List<Reservation> getReservationsByMember(int memberId);
    
}
