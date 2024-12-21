package jpabook.jpashop.service.ReservationService;

import jpabook.jpashop.domain.Reservation;
import jpabook.jpashop.repository.ReservationRepository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationQueryService {
    private final ReservationRepository reservationRepository;

    public Optional<Reservation> findReservation(Long id) {
        return reservationRepository.findById(id);
    }
}
