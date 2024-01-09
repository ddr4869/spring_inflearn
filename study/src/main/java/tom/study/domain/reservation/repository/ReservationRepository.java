package tom.study.domain.reservation.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import tom.study.domain.reservation.model.entity.Reservation;
import tom.study.domain.reservation.repository.custom.CustomReservationRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long>, CustomReservationRepository {

    List<Reservation> findByCustomerId(String customerId);
    Reservation findByReservationPaymentFilm(String reservationPaymentFilm);

    List<Reservation> findFirst2ByCustomerId(String customerId);
}
