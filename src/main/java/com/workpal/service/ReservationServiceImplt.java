package main.java.com.workpal.service;

import main.java.com.workpal.model.Reservation;
import main.java.com.workpal.repository.ReservationRepositoryImplt;

import java.util.List;

public class ReservationServiceImplt implements ReservationService {

    private  ReservationRepositoryImplt reservationRepositoryImplt;

    public ReservationServiceImplt(ReservationRepositoryImplt reservationRepositoryImplt) {
        this.reservationRepositoryImplt = reservationRepositoryImplt;
    }

    public void addReservation(int memberId, int spaceId, String reservationStartDate, String reservationEndDate) {
        reservationRepositoryImplt.addReservation(memberId, spaceId, reservationStartDate, reservationEndDate);
      
    }

    public List<Reservation> getReservationsByMember(int memberId) {
        return reservationRepositoryImplt.getReservationsByMember(memberId);
    }
    
}
