package com.example.Healthcare.repository;


import com.example.Healthcare.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}