
package main.java.com.workpal.service;

import main.java.com.workpal.model.Reservation;
import main.java.com.workpal.repository.ReservationRepositoryImplt;

import java.util.List;

public class ReservationServiceImplt implements ReservationService {

    private  ReservationRepositoryImplt reservationRepositoryImplt;
    private EmailServiceImpl emailService;

    public ReservationServiceImplt(ReservationRepositoryImplt reservationRepositoryImplt) {
        this.reservationRepositoryImplt = reservationRepositoryImplt;
    }


    public void addReservation(int memberId, int spaceId, String reservationStartDate, String reservationEndDate) {
        reservationRepositoryImplt.addReservation(memberId, spaceId, reservationStartDate, reservationEndDate);
        emailService.sendEmail("daali.22.ss@gmail.com", "Reservation Confirmation", "Your reservation has been confirmed.");
    }

    public List<Reservation> getReservationsByMember(int memberId) {
        return reservationRepositoryImplt.getReservationsByMember(memberId);
    }
    
}
