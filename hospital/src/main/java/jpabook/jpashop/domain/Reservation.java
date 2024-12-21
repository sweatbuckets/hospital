package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.base.BaseEntity;
import jpabook.jpashop.domain.enums.ReservationStatus;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Reservation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime time;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Treatment treatment;


    public Reservation changeStatus(ReservationStatus newStatus) {
        return builder()
                .id(this.id)
                .time(this.time)
                .reservationStatus(newStatus)
                .patient(this.patient)
                .doctor(this.doctor)
                .treatment(this.treatment)
                .build();
    }
}