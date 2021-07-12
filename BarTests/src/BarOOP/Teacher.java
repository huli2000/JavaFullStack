package BarOOP;
public class Teacher extends Person{
    private final String profession;

    public Teacher(String name, int age, String profession) {
        super(name, age);
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }
}

