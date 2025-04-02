package Models.Entity;

public class Person {
    private String name;
    private String lastName;
    private String DUI;
    private Integer age;

    public Person(String name, String lastName, String DUI, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.DUI = DUI;
        this.age = age;
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

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
