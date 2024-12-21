package jpabook.jpashop.controller;

import jakarta.validation.Valid;
import jpabook.jpashop.apiPayload.ApiResponse;
import jpabook.jpashop.converter.HospitalConverter;
import jpabook.jpashop.converter.ReservationConverter;
import jpabook.jpashop.domain.Hospital;
import jpabook.jpashop.domain.Reservation;
import jpabook.jpashop.service.ReservationService.ReservationCommandService;
import jpabook.jpashop.service.ReservationService.ReservationQueryService;
import jpabook.jpashop.web.dto.ReservationRequestDTO;
import jpabook.jpashop.web.dto.ReservationResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static jpabook.jpashop.domain.QHospital.hospital;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/{user_id}/reservations")
public class ReservationRestController {
    private final ReservationQueryService reservationQueryService;
    private final ReservationCommandService reservationCommandService;

    @GetMapping("/{reservation_id}")
    public ApiResponse<ReservationResponseDTO.ReservationResultDTO> findReservation(@PathVariable("reservation_id") Long reservationId) {
        Optional<Reservation> reservation = reservationQueryService.findReservation(reservationId);
        return ApiResponse.onSuccess(ReservationConverter.toReservationResultDTO(reservation, "예약 정보"));
    }

    @PostMapping("/")
    public ApiResponse<ReservationResponseDTO.ReservationResultDTO> makeReservation(@RequestBody @Valid ReservationRequestDTO.ReservationDTO request){
        return ApiResponse.onSuccess(reservationCommandService.makeReservation(request));
    }

    @PatchMapping("/{reservation_id}")
    public ApiResponse<ReservationResponseDTO.ReservationResultDTO> acceptReservation(@PathVariable("reservation_id") Long reservationId){
        return ApiResponse.onSuccess(reservationCommandService.acceptReservation(reservationId));
    }
}
