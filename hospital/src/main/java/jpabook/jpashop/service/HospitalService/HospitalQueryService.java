package jpabook.jpashop.service.HospitalService;

import jpabook.jpashop.domain.Hospital;
import jpabook.jpashop.repository.HospitalRepository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HospitalQueryService {
    private final HospitalRepository hospitalRepository;

    public Optional<Hospital> findHospital(Long id){
        return hospitalRepository.findById(id);
    }
}