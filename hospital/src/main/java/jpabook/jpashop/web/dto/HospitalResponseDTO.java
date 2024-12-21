package jpabook.jpashop.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class HospitalResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HospitalResultDTO {
        String message;
        Long hospital_id;
        String hospital_name;
        String address;
    }
}
