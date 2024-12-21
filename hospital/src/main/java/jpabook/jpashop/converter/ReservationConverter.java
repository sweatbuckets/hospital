package jpabook.jpashop.converter;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Doctor;
import jpabook.jpashop.domain.Patient;
import jpabook.jpashop.domain.Reservation;
import jpabook.jpashop.domain.Treatment;
import jpabook.jpashop.domain.enums.ReservationStatus;
import jpabook.jpashop.web.dto.ReservationRequestDTO;
import jpabook.jpashop.web.dto.ReservationResponseDTO;

import java.time.LocalDateTime;
import java.util.Optional;

public class ReservationConverter {

    public static ReservationResponseDTO.ReservationResultDTO toReservationResultDTO(Optional<Reservation> reservation, String message) {
        return ReservationResponseDTO.ReservationResultDTO.builder()
                .message(message)
                .reservationId(reservation.get().getId())
                .doctorName(reservation.get().getDoctor().getName())
                .patientName(reservation.get().getPatient().getName())
                .time(reservation.get().getTime())
                .build();
    }

    public static Reservation toReservation(ReservationRequestDTO.ReservationDTO reservationDTO, Optional<Patient> patient, Optional<Doctor> doctor) {
        return Reservation.builder()
                .time(reservationDTO.getTime())
                .reservationStatus(ReservationStatus.WAITING)
                .patient(patient.get())
                .doctor(doctor.get())
                .treatment(null)
                .build();
    }
}
