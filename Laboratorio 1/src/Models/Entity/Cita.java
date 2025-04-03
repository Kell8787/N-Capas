package Models.Entity;

import Managers.PatientManager;

import java.util.Date;

public class Cita {
    private Person patient;
    private Doctor doctor;
    private Date date;
    private String time;

    public Cita(Person patient, Doctor doctor, Date date, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public Cita(String patientName, String doctor, Date date, String timeStr) {

    }

    public Person getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
