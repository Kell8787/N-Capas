package Managers;

import Models.Entity.Doctor;
import Models.Entity.Person;
import java.util.List;

public class DuiValidation {
    public static boolean isValidDui(String dui) {
        if (dui == null || dui.length() != 9) {
            return false;
        }

        for (char c : dui.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isDuiUniqueForDoctors(String dui, List<Doctor> doctors) {
        for (Doctor doctor : doctors) {
            if (doctor.getDUI().equals(dui)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDuiUniqueForPatients(String dui, List<Person> patients) {
        for (Person person : patients) {
            if (person.getDUI().equals(dui)) {
                return false;
            }
        }
        return true;
    }
}
