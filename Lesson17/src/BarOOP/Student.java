package BarOOP;
import java.util.Arrays;

public class Student extends Person {
    private Grade[] grades = new Grade[6];

    public Student(String name, int age, Grade[] grades) {
        super(name, age);
        this.grades = grades;
    }

    public Grade[] getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return String.format("Student:grades= %sage= %dname= %s", Arrays.toString(grades), getAge(), getName());
    }
}
