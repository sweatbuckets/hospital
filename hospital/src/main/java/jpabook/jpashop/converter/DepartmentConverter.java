package jpabook.jpashop.converter;

import jpabook.jpashop.domain.Department;
import jpabook.jpashop.web.dto.DepartmentResponseDTO;

import java.util.Optional;

public class DepartmentConverter {

    public static DepartmentResponseDTO.DepartmentResultDTO toDepartmentResultDTO(Optional<Department> department) {
        return DepartmentResponseDTO.DepartmentResultDTO.builder()
                .message(department.get().getName()+" 정보")
                .hospital_name(department.get().getHospital().getName())
                .department_id(department.get().getId())
                .department(department.get().getName())
                .tel(department.get().getTelNumber())
                .build();
    }
}
