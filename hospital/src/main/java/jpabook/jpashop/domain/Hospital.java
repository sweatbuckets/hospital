package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.base.BaseEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Hospital extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address ;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Department> departmentList = new ArrayList<>();

}
