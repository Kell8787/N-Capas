package Managers;

import Models.Entity.Cita;
import Models.Entity.Doctor;
import Models.Entity.Person;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class CitaManager {
    private static final List<Cita> citas = new ArrayList<>();
    private static final List<Doctor> doctors = new ArrayList<>();


    public static void addCita(Scanner scanner) {
        System.out.println("Enter patient´s dui:");
        String dui = scanner.next();

        List<Person> patients = new ArrayList<>(PatientManager.getPatients());

        Person patientDUI = null;
        for (Person p : patients){
            if (p.getDUI().equals(dui)){
                patientDUI = p;
                break;
            }
        }

        if (patientDUI == null) {
            System.out.println("Patient not found. Please add the patient first.");
            return;
        }



        System.out.println("Enter Doctor´s name");
        String ScanDoctor = scanner.next();

        System.out.println("Select the doctor's specialty:");
        System.out.println("1. Cardiología");
        System.out.println("2. Neurología");
        System.out.println("3. Pediatría");
        System.out.println("4. Dermatología");
        System.out.println("5. Otra (especificar)");

        int specialtyOption = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        String scanSpecialty;
        switch (specialtyOption) {
            case 1:
                scanSpecialty = "Cardiología";
                break;
            case 2:
                scanSpecialty = "Neurología";
                break;
            case 3:
                scanSpecialty = "Pediatría";
                break;
            case 4:
                scanSpecialty = "Dermatología";
                break;
            case 5:
                System.out.println("Enter the doctor's specialty:");
                scanSpecialty = scanner.nextLine();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                return;
        }

        List<Doctor> doctors = new ArrayList<>(DoctorManager.getDoctors());

        Doctor doctorName = null;
        for (Doctor d : doctors) {
            if (d.getName().equals(ScanDoctor) && d.getSpecialty().equals(scanSpecialty)) {
                doctorName = d;
                break;
            }
        }
            if (doctorName == null) {
                System.out.println("Doctor not found. Please add the doctor first.");
                return;
            }


        System.out.println("Enter appointment date (YYYY-MM-DD)");
        String dateStr = scanner.next();
        Date date = java.sql.Date.valueOf(dateStr);

        Date currentDate = new Date();
        if (date.before(currentDate) && !isSameDay(date, currentDate)) {
            System.out.println("The date you entered is before the current date!");
            return;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format");
            return;
        }

        if (date==null){
            System.out.println("The date cannot be null");
            return;
        }

        System.out.println("Enter the appointment time (HH:MM):");
        String time = scanner.next();

        if (!isValidTime(time)) {
            System.out.println("The time you entered is not valid!");
            return;
        }
        if (isValidDate(date, time, patientDUI, doctorName)) {
            System.out.println("The appointment already exists!");
            return;
        }

        LocalTime dateTime = LocalTime.parse(time);
        LocalTime endTime = dateTime.plusHours(1);

        for (Cita appointment : citas ) {
            if (appointment.getPatient().equals(patientDUI) && appointment.getDate().equals(date)) {
                LocalTime existingTime = LocalTime.parse(appointment.getTime());
                LocalTime existingEndTime = endTime.plusHours(1);

                if((dateTime.isBefore(existingEndTime) && endTime.isAfter(existingTime))){
                    System.out.println("Patient already has an appointment at this time");
                    return;
                }
            }
        }

        for(Cita appointment : citas) {
            if(appointment.getDoctor().equals(doctorName) && appointment.getDate().equals(date)){
                LocalTime existingTime = LocalTime.parse(appointment.getTime());
                LocalTime existingEndTime = endTime.plusHours(1);

                if((dateTime.isBefore(existingEndTime) && endTime.isAfter(existingTime))){
                    System.out.println("Doctor already has an appointment at this time");
                    return;
                }
            }
        }

        Cita cita = new Cita(patientDUI, doctorName, date, time);
            citas.add(cita);
        System.out.println("✅ Appointment added successfully!");
    }

    public static void listAppointments() {
        if (citas.isEmpty()) {
            System.out.println("No Appointments found");
            return;
        }
        System.out.println("-------- Appointment List ----------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Cita cita : citas) {
            Date date = cita.getDate();
            if (date == null) {
                System.out.println("Invalid appointment date");
                continue;
            }
            Doctor doctor = cita.getDoctor();
            if (doctor == null) {
                System.out.println("Invalid doctor information");
                continue;
            }
            String dateStr = dateFormat.format(date);
            String doctorName = doctor.getName() + " " + doctor.getLastName();
            String patientName = cita.getPatient().getName();
            String specialty = doctor.getSpecialty();
            String time = cita.getTime();

            System.out.println("📅 Date: " + dateStr);
            System.out.println("🕒 Time: " + time);
            System.out.println("🏥 Specialty: " + specialty);
            System.out.println("👨‍⚕️ Doctor: Dr." + doctorName);
            System.out.println("🧑 Patient: " + patientName);
            System.out.println("-----------------------------------------");
        }
    }

    private static boolean isValidTime(String time) {
        try {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            return (hour >= 0 && hour < 24) && (minute >= 0 && minute < 60);
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isValidDate(Date date, String time, Person patient, Doctor doctor) {
        for (Cita appointment : citas) {
            if (appointment.getDoctor().equals(doctor) && appointment.getDate().equals(date) && appointment.getTime().equals(time)) {
                return true;
            }
        }

        for (Cita appointment : citas) {
            if (appointment.getPatient().equals(patient) && appointment.getDate().equals(date) && appointment.getTime().equals(time)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSameDay(Date date1, Date date2) {
        return date1.getYear() == date2.getYear() &&
                date1.getMonth() == date2.getMonth() &&
                date1.getDate() == date2.getDate();
    }
}
