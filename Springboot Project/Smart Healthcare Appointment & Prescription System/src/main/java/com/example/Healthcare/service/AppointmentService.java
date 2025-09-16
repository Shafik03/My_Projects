package com.example.Healthcare.service;

import com.example.Healthcare.model.*;
import com.example.Healthcare.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    public List<Appointment> findAppointmentsForDoctorBetween(Long doctorId, LocalDateTime start, LocalDateTime end) {
        return
                appointmentRepository.findByDoctorIdAndAppointmentTimeBetween(doctorId, start, end);
    }
    @Transactional
    public Appointment bookAppointment(Long doctorId, Long patientId,
                                       LocalDateTime when) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()->
                new IllegalArgumentException("Doctor not found"));
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        Appointment appt = new Appointment();
        appt.setDoctor(doctor);
        appt.setPatient(patient);
        appt.setAppointmentTime(when);
        appt.setStatus(AppointmentStatus.PENDING);
        return appointmentRepository.save(appt);
    }
    public List<Appointment> findByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}