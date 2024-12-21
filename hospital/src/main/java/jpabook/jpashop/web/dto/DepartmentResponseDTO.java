package jpabook.jpashop.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class DepartmentResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DepartmentResultDTO {
        String message;
        String hospital_name;
        Long department_id;
        String department;
        String tel;
    }
}
