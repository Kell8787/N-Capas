package Managers;

import Models.Entity.Doctor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DoctorManager {
    private static final List<Doctor> doctors = new ArrayList<>();
    private static final Random random = new Random();

    public static List<Doctor> getDoctors(){
        return new ArrayList<>(doctors);
    }

    Scanner scanner = new Scanner(System.in);

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

        System.out.println("Select the doctor's specialty:");
        System.out.println("1. Cardiología");
        System.out.println("2. Neurología");
        System.out.println("3. Pediatría");
        System.out.println("4. Dermatología");
        System.out.println("5. Otra (especificar)");

        int specialtyOption = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        String specialty;
        switch (specialtyOption) {
            case 1:
                specialty = "Cardiología";
                break;
            case 2:
                specialty = "Neurología";
                break;
            case 3:
                specialty = "Pediatría";
                break;
            case 4:
                specialty = "Dermatología";
                break;
            case 5:
                System.out.println("Enter the doctor's specialty:");
                specialty = scanner.nextLine();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                return;
        }

        System.out.println("Enter the doctor's contract date (YYYY-MM-DD):");
        String contractDate = scanner.next();

        String code = generateRandomCode();

        Doctor doctor = new Doctor(name, lastName, dui, age, specialty, contractDate,code);
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
}
