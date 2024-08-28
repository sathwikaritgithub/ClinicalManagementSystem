import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Patient {
    private int id;
    private String name;
    private String contactNumber;
    private String medicalHistory;

    public Patient(int id, String name, String contactNumber, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.medicalHistory = medicalHistory;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", medicalHistory='" + medicalHistory + '\'' +
                '}';
    }
}

class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String contactNumber;

    public Doctor(int id, String name, String specialization, String contactNumber) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}

class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private LocalDateTime appointmentDateTime;

    public Appointment(int id, int patientId, int doctorId, LocalDateTime appointmentDateTime) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDateTime = appointmentDateTime;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", appointmentDateTime=" + appointmentDateTime +
                '}';
    }
}

public class ClinicManagementSystem {
    private HashMap<Integer, Patient> patients = new HashMap<>();
    private HashMap<Integer, Doctor> doctors = new HashMap<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Methods to add, remove, and update patients
    public void addPatient(Patient patient) {
        patients.put(patient.getId(), patient);
        System.out.println("Patient added: " + patient);
    }

    public void removePatient(int patientId) {
        patients.remove(patientId);
        System.out.println("Patient removed with ID: " + patientId);
    }

    public void updatePatient(int patientId, Patient updatedPatient) {
        patients.put(patientId, updatedPatient);
        System.out.println("Patient updated: " + updatedPatient);
    }

    // Methods to add, remove, and update doctors
    public void addDoctor(Doctor doctor) {
        doctors.put(doctor.getId(), doctor);
        System.out.println("Doctor added: " + doctor);
    }

    public void removeDoctor(int doctorId) {
        doctors.remove(doctorId);
        System.out.println("Doctor removed with ID: " + doctorId);
    }

    public void updateDoctor(int doctorId, Doctor updatedDoctor) {
        doctors.put(doctorId, updatedDoctor);
        System.out.println("Doctor updated: " + updatedDoctor);
    }

    // Method to schedule appointments
    public void scheduleAppointment(int patientId, int doctorId, LocalDateTime appointmentDateTime) {
        for (Appointment appointment : appointments) {
            if (appointment.getDoctorId() == doctorId && appointment.getAppointmentDateTime().equals(appointmentDateTime)) {
                System.out.println("Appointment conflict! Choose another time.");
                return;
            }
        }
        Appointment newAppointment = new Appointment(appointments.size() + 1, patientId, doctorId, appointmentDateTime);
        appointments.add(newAppointment);
        System.out.println("Appointment scheduled: " + newAppointment);
    }

    // Interactive console
    public void interactiveConsole() {
        while (true) {
            System.out.println("\nClinic Management System Menu:");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Add Doctor");
            System.out.println("5. Remove Doctor");
            System.out.println("6. Update Doctor");
            System.out.println("7. Schedule Appointment");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addPatientInteractive();
                    break;
                case 2:
                    removePatientInteractive();
                    break;
                case 3:
                    updatePatientInteractive();
                    break;
                case 4:
                    addDoctorInteractive();
                    break;
                case 5:
                    removeDoctorInteractive();
                    break;
                case 6:
                    updateDoctorInteractive();
                    break;
                case 7:
                    scheduleAppointmentInteractive();
                    break;
                case 8:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addPatientInteractive() {
        System.out.print("Enter patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter patient medical history: ");
        String medicalHistory = scanner.nextLine();

        Patient patient = new Patient(id, name, contactNumber, medicalHistory);
        addPatient(patient);
    }

    private void removePatientInteractive() {
        System.out.print("Enter patient ID to remove: ");
        int id = scanner.nextInt();
        removePatient(id);
    }

    private void updatePatientInteractive() {
        System.out.print("Enter patient ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new patient contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter new patient medical history: ");
        String medicalHistory = scanner.nextLine();

        Patient updatedPatient = new Patient(id, name, contactNumber, medicalHistory);
        updatePatient(id, updatedPatient);
    }

    private void addDoctorInteractive() {
        System.out.print("Enter doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter doctor specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter doctor contact number: ");
        String contactNumber = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, specialization, contactNumber);
        addDoctor(doctor);
    }

    private void removeDoctorInteractive() {
        System.out.print("Enter doctor ID to remove: ");
        int id = scanner.nextInt();
        removeDoctor(id);
    }

    private void updateDoctorInteractive() {
        System.out.print("Enter doctor ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new doctor specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter new doctor contact number: ");
        String contactNumber = scanner.nextLine();

        Doctor updatedDoctor = new Doctor(id, name, specialization, contactNumber);
        updateDoctor(id, updatedDoctor);
    }

    private void scheduleAppointmentInteractive() {
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter appointment date and time (yyyy-MM-ddTHH:mm): ");
        String appointmentDateTimeStr = scanner.nextLine();
        LocalDateTime appointmentDateTime = LocalDateTime.parse(appointmentDateTimeStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        scheduleAppointment(patientId, doctorId, appointmentDateTime);
    }

    // Main method to run the application
    public static void main(String[] args) {
        ClinicManagementSystem system = new ClinicManagementSystem();
        system.interactiveConsole();
    }
}
