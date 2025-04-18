package Models.Entity;

import java.util.Date;

public class Doctor extends Person{
    private String specialty;
    private String contract;
    private String code;

    public Doctor(String name, String lastName, String DUI, int age, String specialty, String contract, String code) {
        super(name, lastName, DUI, age);
        this.specialty = specialty;
        this.contract = contract;
        this.code = code;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
