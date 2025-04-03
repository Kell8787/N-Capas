import Managers.CitaManager;
import Managers.DoctorManager;
import Managers.PatientManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do{
            System.out.println("-----MAIN MENU-----");
            System.out.println("1. View All Appointment");
            System.out.println("2. Add New Appointment");
            System.out.println("3. Add New Doctor");
            System.out.println("4. Add New Patient");
            System.out.println("5. Special Button");
            System.out.println("6. Exit");
            System.out.println("-------------------");
            System.out.print("Please select an option: ");

            while(!scanner.hasNextInt()) {
                System.out.println("Please enter a valid option");
                scanner.next();
            }
            option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1:
                    System.out.println("Showing date...");
                    CitaManager.listAppointments();
                    break;
                case 2:
                    System.out.println("Adding date...");
                    CitaManager.addCita(scanner);
                    break;
                case 3:
                    System.out.println("Adding Doctor...");
                    System.out.println("-----------------------");
                    DoctorManager.addDoctor(scanner);
                    System.out.println("-----------------------");
                    break;
                case 4:
                    System.out.println("Adding Patient...");
                    System.out.println("-----------------------");
                    PatientManager.addPatient(scanner);
                    System.out.println("-----------------------");
                    break;
                case 5:
                    System.out.println("-----------------------");
                    System.out.println("MUNDO SALVA VIDAS!!!");
                    System.out.println("-----------------------");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        while(option != 6);

        scanner.close();
    }
}
