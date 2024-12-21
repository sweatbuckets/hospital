package jpabook.jpashop.converter;

import jpabook.jpashop.domain.Doctor;
import jpabook.jpashop.web.dto.DoctorResponseDTO;

import java.util.Optional;

public class DoctorConverter {
    public static DoctorResponseDTO.DoctorResultDTO toDoctorResultDTO(Optional<Doctor> doctor) {
        return DoctorResponseDTO.DoctorResultDTO.builder()
                .message(doctor.get().getName()+"의사 정보")
                .doctor_id(doctor.get().getId())
                .doctor_name(doctor.get().getName())
                .department(doctor.get().getDepartment().getName())
                .career(doctor.get().getCareer())
                .build();
    }
}
