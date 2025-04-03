package Managers;

import Models.Entity.Cita;
import Models.Entity.Doctor;
import Models.Entity.Person;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CitaManager {
    private static final List<Cita> citas = new ArrayList<>();

    public static void addCita(Scanner scanner) {
        System.out.println("Enter patient´s name");
        String patientName = scanner.next();

        //Validate if patient has another appointment

        System.out.println("Enter Doctor´s name");
        String doctor = scanner.next();

        //Validate if the doctor has another date


        System.out.println("Enter appointment date (YYYY-MM-DD)");
        String dateStr = scanner.next();
        Date date = new Date();
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

        System.out.println("Enter appointment time (HH:MM)");
        String timeStr = scanner.next();

        Cita cita = new Cita(patientName, doctor, date, timeStr);
            citas.add(cita);
            System.out.println("Cita added");
    }

public static void listAppointments() {
        if (citas.isEmpty()) {
            System.out.println("No Appointments found");
            return;
        }
        System.out.println("-------- Appointment List ----------");
        for (Cita cita : citas) {
            String date = cita.getDate().toString();
            String doctorName = cita.getDoctor().getName();
            String patientName = cita.getPatient().getName();
            String speciality = cita.getDoctor().getSpecialty();

            System.out.println(cita.getDate() + " " + doctorName + " " + patientName + " " + speciality);
        }
}

}
