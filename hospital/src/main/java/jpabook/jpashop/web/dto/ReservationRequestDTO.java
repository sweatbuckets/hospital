package jpabook.jpashop.web.dto;

import jpabook.jpashop.domain.enums.ReservationStatus;
import lombok.Getter;

import java.time.LocalDateTime;

public class ReservationRequestDTO {
    @Getter
    public static class ReservationDTO{
        Long patient_id;

        Long doctor_id;

        LocalDateTime time;
    }
}
