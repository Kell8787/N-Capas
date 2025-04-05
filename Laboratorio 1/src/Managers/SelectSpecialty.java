package Managers;

import java.util.Scanner;

public class SelectSpecialty {
    public static String selectSpecialty(Scanner scanner) {
        System.out.println("Select the doctor's specialty:");
        System.out.println("1. Cardiología");
        System.out.println("2. Neurología");
        System.out.println("3. Pediatría");
        System.out.println("4. Dermatología");
        System.out.println("5. Otra (especificar)");

        int specialtyOption = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        switch (specialtyOption) {
            case 1:
                return "Cardiología";
            case 2:
                return "Neurología";
            case 3:
                return "Pediatría";
            case 4:
                return "Dermatología";
            case 5:
                System.out.println("Enter the doctor's specialty:");
                return scanner.nextLine();
            default:
                return null;
        }
    }
}
