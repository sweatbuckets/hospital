package jpabook.jpashop.service.DepartmentService;

import jpabook.jpashop.domain.Department;
import jpabook.jpashop.repository.DepartmentRepository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentQueryService {
    private final DepartmentRepository departmentRepository;

    public Optional<Department> findDepartment(Long id) {
        return departmentRepository.findById(id);
    }
}
