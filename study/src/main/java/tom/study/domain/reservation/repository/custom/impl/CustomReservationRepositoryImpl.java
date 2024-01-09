package tom.study.domain.reservation.repository.custom.impl;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import tom.study.domain.customer.model.entity.QCustomer;
import tom.study.domain.reservation.model.entity.QReservation;
import tom.study.domain.reservation.model.entity.Reservation;
import tom.study.domain.reservation.repository.custom.CustomReservationRepository;

import java.util.List;

@RequiredArgsConstructor
public class CustomReservationRepositoryImpl implements CustomReservationRepository {
    private final JPAQueryFactory queryFactory;

    public List<Reservation> findReservations() {
        QReservation r = QReservation.reservation;
        return queryFactory.selectFrom(r).
                where(r.customerId.eq("tom")).
                fetch();
    }

    public List<Tuple> findReservations2() {
        QReservation r = QReservation.reservation;
        return queryFactory.select(r.customerId, r.reservationPaymentScheduleId).from(r).
                where(r.reservationPaymentId.eq(5L)).
                fetch();
    }

    public List<Reservation> findReservations3(String customName) {
        QReservation r = QReservation.reservation;
        QCustomer c = QCustomer.customer;
        return queryFactory.selectFrom(r).
                join(c).on(r.customerId.eq(c.customerName)).
                where(c.customerName.eq(customName)).
                fetch();
    }
}

