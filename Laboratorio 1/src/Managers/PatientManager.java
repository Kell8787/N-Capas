package Managers;

import Models.Entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientManager {
    private static final List<Person> patients = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int option;


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
            System.out.println("Enter the patiennt's DUI:");
            dui = scanner.next();
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
