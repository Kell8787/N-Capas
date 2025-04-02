package Managers;

import Models.Entity.Doctor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DoctorManager {
    private static final List<Doctor> doctors = new ArrayList<>();
    private static final Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public static void addDoctor(Scanner scanner) {
        System.out.println("Enter the doctor's name:");
        String name = scanner.next();

        System.out.println("Enter the doctor's last name:");
        String lastName = scanner.next();

        System.out.println("Enter the doctor's age:");
        Integer age = Integer.parseInt(scanner.next());

        if (age <25){
            System.out.println("The doctor is too young to work.");
            return;
        }

        System.out.println("Enter the doctor's DUI:");
        String dui = scanner.next();

        System.out.println("Enter the doctor's specialty:");
        String specialty = scanner.next();

        System.out.println("Enter the doctor's contract date (YYYY-MM-DD):");
        String contractDate = scanner.next();

        String code = generateRandomCode();

        Doctor doctor = new Doctor(name, lastName, dui, age, specialty, contractDate,code);
        doctors.add(doctor);
        System.out.println("Doctor added Successfully!");
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
