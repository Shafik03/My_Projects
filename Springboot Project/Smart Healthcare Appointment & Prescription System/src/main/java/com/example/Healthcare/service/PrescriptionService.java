package com.example.Healthcare.service;

import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import com.example.Healthcare.model.Prescription;
import com.example.Healthcare.model.Appointment;
import com.example.Healthcare.repository.PrescriptionRepository;
import com.example.Healthcare.repository.AppointmentRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Transactional
    public Prescription createPrescription(Long appointmentId, String content) {
        Appointment appt = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));

        Prescription p = new Prescription();
        p.setAppointment(appt);
        p.setContent(content);
        p.setCreatedAt(LocalDateTime.now());
        return prescriptionRepository.save(p);
    }

    public byte[] generatePrescriptionPdf(Long prescriptionId) throws IOException {
        Prescription p = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new IllegalArgumentException("Prescription not found"));

        Appointment appt = p.getAppointment();

        try (PDDocument doc = new PDDocument();
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            PDPage page = new PDPage();
            doc.addPage(page);

            try (PDPageContentStream cs = new PDPageContentStream(doc, page)) {
                cs.beginText();

                // Use Standard14Fonts for PDFBox 3.x
                PDFont boldFont = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
                PDFont regularFont = new PDType1Font(Standard14Fonts.FontName.HELVETICA);

                cs.setFont(boldFont, 16);
                cs.newLineAtOffset(50, 700);
                cs.showText("Prescription");
                cs.newLineAtOffset(0, -25);
                cs.setFont(regularFont, 12);
                cs.showText("Date: " + p.getCreatedAt().toLocalDate().toString());
                cs.newLineAtOffset(0, -20);

                // doctor/patient info
                String docName = appt.getDoctor().getUser().getUsername();
                String patientName = appt.getPatient().getUser().getUsername();
                cs.showText("Doctor: " + docName);
                cs.newLineAtOffset(0, -20);
                cs.showText("Patient: " + patientName);
                cs.newLineAtOffset(0, -20);
                cs.showText("Appointment: " + appt.getAppointmentTime().toString());
                cs.newLineAtOffset(0, -30);

                // prescription content
                String[] lines = p.getContent().split("\\n");
                for (String line : lines) {
                    cs.showText(line);
                    cs.newLineAtOffset(0, -15);
                }

                cs.endText();
            }

            doc.save(baos);
            return baos.toByteArray();
        }
    }
}