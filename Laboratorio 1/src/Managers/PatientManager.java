package Managers;

import Models.Entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientManager {
    private static final List<Person> patients = new ArrayList<>();

    public static List<Person> getPatients() {
        return new ArrayList<>(patients);
    }

    Scanner scanner = new Scanner(System.in);

    public static void addPatient(Scanner scanner) {
        System.out.println("Enter the patient's name:");
        String name = scanner.nextLine();
        System.out.println("Enter the patient's last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter the patient's age:");
        Integer age = Integer.parseInt(scanner.nextLine());

        String dui;
        if (age < 18){
            dui = "00000000-0";
        }
        else{
            do {
                System.out.println("Enter the patient's DUI:");
                dui = scanner.next();
                if (!DuiValidation.isValidDui(dui)) {
                    System.out.println("Invalid DUI. Please enter a valid DUI.");
                } else if (!DuiValidation.isDuiUniqueForPatients(dui, patients)) {
                    System.out.println("DUI already exists for another patient. Please enter a unique DUI.");
                }
            } while (!DuiValidation.isValidDui(dui) || !DuiValidation.isDuiUniqueForPatients(dui, patients));
        }


        Person patient = new Person(name, lastName, dui, age);
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }
    public static void listPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("List of patients:");
            int count = 1;
            for (Person patient : patients) {
                System.out.println(count + ". " + patient.getName() +  patient.getLastName());
                count++;
            }
        }
    }
}
