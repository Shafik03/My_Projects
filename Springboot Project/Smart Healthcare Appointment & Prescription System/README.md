# Healthcare Management System

This is a Spring Boot application that serves as a backend for a healthcare management system. It provides functionalities for user authentication, appointment booking, and prescription management.

## Features

-   **User Management:** Register and authenticate users with different roles (Patient, Doctor, Admin).
-   **JWT Authentication:** Secure API endpoints using JSON Web Tokens (JWT).
-   **Appointment Scheduling:** Patients can book appointments with doctors.
-   **Prescription Generation:** Doctors can create digital prescriptions.
-   **PDF Generation:** Prescriptions can be downloaded as PDF files.
-   **API Endpoints:** RESTful APIs for all functionalities.

## Technologies Used

-   **Spring Boot 3.x:** Framework for building the application.
-   **Spring Security:** Handles authentication and authorization.
-   **JWT (jjwt):** For token-based authentication.
-   **Spring Data JPA:** For database interactions.
-   **H2 Database:** In-memory database for development and testing.
-   **Lombok:** Reduces boilerplate code.
-   **Apache PDFBox:** For generating PDF documents from prescriptions.

## Prerequisites

-   Java 24 or higher
-   Maven

## Getting Started

1.  **Clone the repository:**
    ```bash
    git clone <repository_url>
    ```

2.  **Build the project:**
    Navigate to the project root directory and run the following command:
    ```bash
    mvn clean install
    ```

3.  **Run the application:**
    You can run the application using the Spring Boot Maven plugin:
    ```bash
    mvn spring-boot:run
    ```
    The application will start on port `8080` (by default).

## API Endpoints

### Authentication

-   `POST /api/auth/register`: Register a new user.
    -   `Body`: `{"username": "...", "email": "...", "password": "...", "role": "PATIENT"}`
-   `POST /api/auth/login`: Authenticate and get a JWT token.
    -   `Body`: `{"username": "...", "password": "..."}`
    -   `Response`: `{"token": "..."}`

### Appointments

-   `POST /api/appointments/book`: Book a new appointment.
    -   `Parameters`: `doctorId`, `patientId`, `when`
-   `GET /api/appointments/doctor/{doctorId}/between`: Find appointments for a doctor within a date range.
    -   `Parameters`: `start`, `end`

### Prescriptions

-   `POST /api/prescriptions/create`: Create a prescription for an appointment.
    -   `Parameters`: `appointmentId`
    -   `Body`: `{"content": "..."}`
-   `GET /api/prescriptions/{id}/pdf`: Download a prescription as a PDF.
    -   `Path Variable`: `id`

---
