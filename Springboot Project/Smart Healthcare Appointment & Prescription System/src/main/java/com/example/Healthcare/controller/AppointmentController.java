package com.example.Healthcare.controller;

import com.example.Healthcare.model.Appointment;
import com.example.Healthcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @GetMapping("/doctor/{doctorId}/between")
    public ResponseEntity<?> findBetween(@PathVariable Long doctorId,
                                         @RequestParam("start")
                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                         @RequestParam("end")
                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        List<Appointment> list =
                appointmentService.findAppointmentsForDoctorBetween(doctorId, start, end);
        return ResponseEntity.ok(list);
    }
    @PostMapping("/book")
    public ResponseEntity<?> book(@RequestParam Long doctorId, @RequestParam
                                  Long patientId,
                                  @RequestParam @DateTimeFormat(iso =
                                          DateTimeFormat.ISO.DATE_TIME) LocalDateTime when) {
        Appointment a = appointmentService.bookAppointment(doctorId, patientId,
                when);
        return ResponseEntity.ok(a);
    }
}