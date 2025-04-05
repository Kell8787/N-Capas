import Managers.CitaManager;
import Managers.DoctorManager;
import Managers.PatientManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do{
            System.out.println("╔════════════════════════╗");
            System.out.println("║      📅 MAIN MENU      ║");
            System.out.println("╠════════════════════════╣");
            System.out.println("║ 1️⃣  View All Appointments ║");
            System.out.println("║ 2️⃣  Add New Appointment   ║");
            System.out.println("║ 3️⃣  Add New Doctor        ║");
            System.out.println("║ 4️⃣  Add New Patient       ║");
            System.out.println("║ 5️⃣  Cancel Appointment    ║");
            System.out.println("║ 6️⃣  🔥 Special Button     ║");
            System.out.println("║ 7️⃣  View All Doctors      ║");
            System.out.println("║ 8️⃣  Appointments by Doctor║");
            System.out.println("║ 9️⃣  ❌ Exit               ║");
            System.out.println("╚════════════════════════╝");
            System.out.print("👉 Please select an option: ");

            while(!scanner.hasNextInt()) {
                System.out.println("Please enter a valid option");
                scanner.next();
            }
            option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1:
                    System.out.println("📅 ──── Showing Appointments ────");
                    CitaManager.listAppointments();
                    System.out.println("✅ Appointments displayed successfully!");
                    break;
                case 2:
                    System.out.println("📝 ──── Adding New Appointment ────");
                    CitaManager.addCita(scanner);
                    break;
                case 3:
                    System.out.println("👨‍⚕️ ──── Adding a New Doctor ────");
                    System.out.println("════════════════════════════════");
                    DoctorManager.addDoctor(scanner);
                    System.out.println("════════════════════════════════");
                    break;
                case 4:
                    System.out.println("🩺 ──── Adding a New Patient ────");
                    System.out.println("════════════════════════════════");
                    PatientManager.addPatient(scanner);
                    System.out.println("════════════════════════════════");
                    break;
                case 5:
                    System.out.println("❌ ──── Canceling Appointment ────");
                    System.out.println("════════════════════════════════");
                    CitaManager.cancelAppointment(scanner);
                    System.out.println("════════════════════════════════");
                    break;
                case 6:
                    System.out.println("🚨 ──── SPECIAL BUTTON ────");
                    System.out.println("🌍 MUNDO SALVA VIDAS!!! ❤️");
                    System.out.println("════════════════════════════════");
                    break;
                case 7:
                    System.out.println("👨‍⚕️ ──── Viewing All Doctors ────");
                    System.out.println("════════════════════════════════");
                    DoctorManager.viewAllDoctors();
                    System.out.println("════════════════════════════════");
                    break;
                case 8:
                    System.out.println("🔍 ──── Appointments by Doctor ────");
                    System.out.print("Ingrese el código del doctor: ");
                    String doctorCodeForAppointments = scanner.nextLine();
                    DoctorManager.viewAppointmentsByDoctor(doctorCodeForAppointments);
                    break;
                case 9:
                    System.out.println("👋 Exiting... Thank you for using our system!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        while(option != 9);

        scanner.close();
    }
}
