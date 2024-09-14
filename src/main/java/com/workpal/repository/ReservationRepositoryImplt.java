package main.java.com.workpal.repository;

import main.java.com.workpal.dao.ReservationDaoImplt;
import main.java.com.workpal.model.Reservation;
import java.util.List;

public class ReservationRepositoryImplt implements ReservationRepository {

    private final ReservationDaoImplt reservationDao;

    public ReservationRepositoryImplt(ReservationDaoImplt reservationDao) {
        this.reservationDao = reservationDao;
    }

    public void addReservation(int memberId, int spaceId, String date, String startTime) {
        reservationDao.addReservation(memberId, spaceId, date, startTime);
    }

    public List<Reservation> getReservationsByMember(int memberId) {
        return reservationDao.getReservationsByMember(memberId);
    }
    
}
