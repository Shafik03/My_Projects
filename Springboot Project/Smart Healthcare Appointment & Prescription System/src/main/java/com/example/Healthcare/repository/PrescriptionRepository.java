package com.example.Healthcare.repository;

import com.example.Healthcare.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}