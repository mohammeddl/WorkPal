package main.java.com.workpal.repository;

import main.java.com.workpal.model.Reservation;
import java.util.List;

public interface ReservationRepository {
    void addReservation(int memberId, int spaceId, String startTime, String endTime);
    List<Reservation> getReservationsByMember(int memberId);
    
    
}
