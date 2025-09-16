package com.example.Healthcare.controller;

import com.example.Healthcare.config.JwtTokenUtil;
import com.example.Healthcare.dto.LoginRequest;
import com.example.Healthcare.dto.LoginResponse;
import com.example.Healthcare.dto.RegisterRequest;
import com.example.Healthcare.model.Role;
import com.example.Healthcare.model.User;
import com.example.Healthcare.repository.PatientRepository;
import com.example.Healthcare.repository.DoctorRepository;
import com.example.Healthcare.model.Doctor;
import com.example.Healthcare.model.Patient;
import com.example.Healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import
        org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        Authentication auth = authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String token = jwtTokenUtil.generateToken(req.getUsername());
        return ResponseEntity.ok(new LoginResponse(token));
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        if (userService.findByUsername(req.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already taken");
        }
        User u = new User();
        u.setUsername(req.getUsername());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        if ("DOCTOR".equalsIgnoreCase(req.getRole()))
            u.setRole(Role.ROLE_DOCTOR);
        else u.setRole(Role.ROLE_PATIENT);
        User saved = userService.register(u);
        if (saved.getRole() == Role.ROLE_PATIENT) {
            Patient p = new Patient();
            p.setUser(saved);
            patientRepository.save(p);
        } else if (saved.getRole() == Role.ROLE_DOCTOR) {
            Doctor d = new Doctor();
            d.setUser(saved);
            doctorRepository.save(d);
        }
        return ResponseEntity.ok("Registered");
    }
}