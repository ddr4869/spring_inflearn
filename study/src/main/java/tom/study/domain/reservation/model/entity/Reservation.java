package tom.study.domain.reservation.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import tom.study.domain.customer.model.entity.Customer;

@Entity
@Table
@Getter @Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationPaymentId;


    @Column
    @NotEmpty
    private String customerId;

    @Column
    @NotNull
    private long reservationPaymentScheduleId;

    @Column
    @NotEmpty
    private String reservationPaymentFilm;

//    @ManyToOne
//    private Customer customer;
}
