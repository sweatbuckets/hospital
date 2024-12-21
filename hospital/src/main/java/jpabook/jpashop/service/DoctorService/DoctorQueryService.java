package jpabook.jpashop.service.DoctorService;

import jpabook.jpashop.domain.Doctor;
import jpabook.jpashop.repository.DoctorRepository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DoctorQueryService {
    private final DoctorRepository doctorRepository;

    public Optional<Doctor> findDoctor(Long id){
        return doctorRepository.findById(id);
    }
}
