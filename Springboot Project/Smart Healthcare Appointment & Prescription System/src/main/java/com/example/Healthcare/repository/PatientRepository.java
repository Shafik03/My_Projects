package com.example.Healthcare.repository;

import com.example.Healthcare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PatientRepository extends JpaRepository<Patient, Long> {
}