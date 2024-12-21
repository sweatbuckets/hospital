package jpabook.jpashop.controller;

import jakarta.validation.Valid;
import jpabook.jpashop.apiPayload.ApiResponse;
import jpabook.jpashop.converter.DepartmentConverter;
import jpabook.jpashop.converter.DoctorConverter;
import jpabook.jpashop.converter.HospitalConverter;
import jpabook.jpashop.domain.Department;
import jpabook.jpashop.domain.Doctor;
import jpabook.jpashop.domain.Hospital;
import jpabook.jpashop.service.DepartmentService.DepartmentQueryService;
import jpabook.jpashop.service.DoctorService.DoctorQueryService;
import jpabook.jpashop.service.HospitalService.HospitalQueryService;
import jpabook.jpashop.web.dto.DepartmentResponseDTO;
import jpabook.jpashop.web.dto.DoctorResponseDTO;
import jpabook.jpashop.web.dto.HospitalRequestDTO;
import jpabook.jpashop.web.dto.HospitalResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hospitals")
public class HospitalRestController {
    private final HospitalQueryService hospitalQueryService;
    private final DepartmentQueryService departmentQueryService;
    private final DoctorQueryService doctorQueryService;

    @GetMapping("/{hospital_id}")
    public ApiResponse<HospitalResponseDTO.HospitalResultDTO> findHospital(@PathVariable("hospital_id") Long hospitalId) {
        Optional<Hospital> hospital = hospitalQueryService.findHospital(hospitalId);
        return ApiResponse.onSuccess(HospitalConverter.toHospitalResultDTO(hospital));
    }

    @GetMapping("/{hospital_id}/departments/{department_id}")
    public ApiResponse<DepartmentResponseDTO.DepartmentResultDTO> findDepartment(@PathVariable("department_id") Long departmentId){
        Optional<Department> department = departmentQueryService.findDepartment(departmentId);
        return ApiResponse.onSuccess(DepartmentConverter.toDepartmentResultDTO(department));
    }

    @GetMapping("/{hospital_id}/doctors/{doctor_id}")
    public ApiResponse<DoctorResponseDTO.DoctorResultDTO> findDoctor(@PathVariable("doctor_id") Long doctorId){
        Optional<Doctor> doctor = doctorQueryService.findDoctor(doctorId);
        return ApiResponse.onSuccess(DoctorConverter.toDoctorResultDTO(doctor));
    }
}
