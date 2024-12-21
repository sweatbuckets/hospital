package jpabook.jpashop.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class DoctorResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DoctorResultDTO {
        String message;
        Long doctor_id;
        String doctor_name;
        String department;
        Integer career;
    }
}
