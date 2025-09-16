package com.example.Healthcare.controller;

import com.example.Healthcare.model.Prescription;
import com.example.Healthcare.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestParam Long appointmentId,
                                    @RequestBody String content) {
        Prescription p = prescriptionService.createPrescription(appointmentId,
                content);
        return ResponseEntity.ok(p);
    }
    @GetMapping(value = "/{id}/pdf")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long id) throws
            IOException {
        byte[] pdf = prescriptionService.generatePrescriptionPdf(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=prescription_" + id + ".pdf")
                                .contentType(MediaType.APPLICATION_PDF)
                                .body(pdf);
    }
}