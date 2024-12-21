package jpabook.jpashop.service.ReservationService;

import jpabook.jpashop.converter.ReservationConverter;
import jpabook.jpashop.domain.Doctor;
import jpabook.jpashop.domain.Patient;
import jpabook.jpashop.domain.Reservation;
import jpabook.jpashop.domain.enums.ReservationStatus;
import jpabook.jpashop.repository.DoctorRepository.DoctorRepository;
import jpabook.jpashop.repository.PatientRepository.PatientRepository;
import jpabook.jpashop.repository.ReservationRepository.ReservationRepository;
import jpabook.jpashop.web.dto.ReservationRequestDTO;
import jpabook.jpashop.web.dto.ReservationResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationCommandService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ReservationRepository reservationRepository;

    public ReservationResponseDTO.ReservationResultDTO makeReservation(ReservationRequestDTO.ReservationDTO reservationDTO){
        //1. doctor와 patient 유효성 검사
        Optional<Doctor> doctor = doctorRepository.findById(reservationDTO.getDoctor_id());
        Optional<Patient> patient = patientRepository.findById(reservationDTO.getPatient_id());

        //2. requestDTO, patient, doctor을 갖고 converter를 통해 reservation 객체 생성
        Reservation reservation = ReservationConverter.toReservation(reservationDTO, patient, doctor);
        reservationRepository.save(reservation);

        //3. 생성한 reservation을 reponseDTO로 변환하여 return
        String message = "예약 신청 완료";
        return  ReservationConverter.toReservationResultDTO(Optional.of(reservation), message);
    }

    public ReservationResponseDTO.ReservationResultDTO acceptReservation(Long reservation_id){
        //1. reservation 유효성 검사
        Optional<Reservation> reservation = reservationRepository.findById(reservation_id);

        //2. reservation domain에 정의해둔 changeStatus()메서드로 status가 수정된 newReservation 객체 생성
        Reservation newReservation = reservation.get().changeStatus(ReservationStatus.ACCEPTED);
        reservationRepository.save(newReservation);

        //3. 생성한 newReservation을 responseDTO로 변환하여 return
        String message = "예약 수락";
        return ReservationConverter.toReservationResultDTO(reservation, message);

    }
}
