package Managers;

import Models.Entity.Cita;
import Models.Entity.Doctor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DoctorManager {
    private static final List<Doctor> doctors = new ArrayList<>();
    private static final Random random = new Random();

    public static List<Doctor> getDoctors() {
        return new ArrayList<>(doctors);
    }

    public static void addDoctor(Scanner scanner) {
        System.out.println("Enter the doctor's name:");
        String name = scanner.next();

        System.out.println("Enter the doctor's last name:");
        String lastName = scanner.next();

        Integer age;
        do {
            System.out.println("Enter the doctor's age:");
            age = Integer.parseInt(scanner.next());
            if (age < 25) {
                System.out.println("The doctor is too young to work. Please enter a valid age.");
            }
        } while (age < 25);

        String dui;
        do {
            System.out.println("Enter the doctor's DUI:");
            dui = scanner.next();
            if (!DuiValidation.isValidDui(dui)) {
                System.out.println("Invalid DUI. Please enter a valid DUI.");
            } else if (!DuiValidation.isDuiUniqueForDoctors(dui, doctors)) {
                System.out.println("DUI already exists for another doctor. Please enter a unique DUI.");
            }
        } while (!DuiValidation.isValidDui(dui) || !DuiValidation.isDuiUniqueForDoctors(dui, doctors));

        String specialty = SelectSpecialty.selectSpecialty(scanner);

        if (specialty == null) {
            System.out.println("Invalid option. Please try again.");
            return;
        }

        System.out.println("Enter the doctor's contract date (YYYY-MM-DD):");
        String contractDate = scanner.next();

        String code = generateRandomCode();

        Doctor doctor = new Doctor(name, lastName, dui, age, specialty, contractDate, code);
        doctors.add(doctor);
        System.out.println("✅ Doctor added successfully!");
    }

    private static String generateRandomCode() {

        return "ZNH-" + random.nextInt(10) + // X
                (char) ('A' + random.nextInt(26)) + // A
                random.nextInt(10) + // X
                "-MD-" +
                (char) ('A' + random.nextInt(26)) + // A
                random.nextInt(10);
    }

    public static void viewAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No hay doctores agendados.");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println("╔══════════════════════════════╗");
                System.out.printf("║ 👨‍⚕️ Dr. %s %s%n", doctor.getName(), doctor.getLastName());
                System.out.println("╠══════════════════════════════╣");
                System.out.printf("║ 🆔 DUI: %s%n", doctor.getDUI());
                System.out.printf("║ 🎂 Edad: %d%n", doctor.getAge());
                System.out.printf("║ 🏥 Especialidad: %s%n", doctor.getSpecialty());
                System.out.printf("║ 📄 Contrato: %s%n", doctor.getContract());
                System.out.printf("║ 🧾 Código: %s%n", doctor.getCode());
                System.out.println("╚══════════════════════════════╝");
            }
        }
    }

    public static void viewAppointmentsByDoctor(String doctorCode) {
        List<Cita> citas = CitaManager.getCitas();
        List<Cita> citasDelDoctor = citas.stream()
                .filter(cita -> cita.getDoctor().getCode().equals(doctorCode))
                .collect(Collectors.toList());

        if (citasDelDoctor.isEmpty()) {
            System.out.println("No hay citas agendadas para el doctor con código: " + doctorCode);
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (Cita cita : citasDelDoctor) {
                String dateStr = dateFormat.format(cita.getDate());
                System.out.println("════════════════════════════════");
                System.out.println("🧑 Patient: " + cita.getPatient().getName() + " " + cita.getPatient().getLastName());
                System.out.println("📅 Date: " + dateStr);
                System.out.println("🕒 Time: " + cita.getTime());
                System.out.println("════════════════════════════════");
            }
        }
    }
}

