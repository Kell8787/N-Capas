package Models.DTO;

public class DoctorDTO {
    private String name;
    private String lastName;
    private String specialty;

    public DoctorDTO(String name, String specialty, String lastName) {
        this.name = name;
        this.specialty = specialty;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
