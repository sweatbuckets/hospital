package jpabook.jpashop.converter;

import jpabook.jpashop.domain.Hospital;
import jpabook.jpashop.web.dto.HospitalResponseDTO;

import java.util.Optional;

import static org.apache.tomcat.jni.Buffer.address;

public class HospitalConverter {

    public static HospitalResponseDTO.HospitalResultDTO toHospitalResultDTO(Optional<Hospital> hospital) {
        return HospitalResponseDTO.HospitalResultDTO.builder()
                .hospital_id(hospital.get().getId())
                .message(hospital.get().getName()+" 정보")
                .hospital_name(hospital.get().getName())
                .address(hospital.get().getAddress())
                .build();
    }
}
