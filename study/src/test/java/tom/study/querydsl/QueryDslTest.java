package tom.study.querydsl;

import com.querydsl.core.Tuple;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tom.study.domain.reservation.model.entity.QReservation;
import tom.study.domain.reservation.model.entity.Reservation;
import tom.study.domain.reservation.repository.ReservationRepository;

import java.util.List;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
public class QueryDslTest {

    @Autowired
    ReservationRepository reservationRepository;

    @Test
    void QueryDSLTest() {
        List<Reservation> reservations = reservationRepository.findReservations();
        for(Reservation r: reservations) {
            log.info("{}, {}, {}, {}",r.getReservationPaymentId(), r.getCustomerId(),
                    r.getReservationPaymentScheduleId(), r.getReservationPaymentFilm());
        }
    }
    @Test
    void QueryDSLTest2() {
        List<Tuple> reservations = reservationRepository.findReservations2();
        for(Tuple t: reservations) {
            log.info("{}, {}", t.get(QReservation.reservation.customerId), t.get(QReservation.reservation.reservationPaymentScheduleId));
        }
    }

    @Test
    void QueryDSLTest3() {
        List<Reservation> reservations = reservationRepository.findReservations3("tom");
        for(Reservation r: reservations) {
            log.info("{}, {}, {}, {}",r.getReservationPaymentId(), r.getCustomerId(),
                    r.getReservationPaymentScheduleId(), r.getReservationPaymentFilm());
        }
    }
}
