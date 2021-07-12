package BarOOP;
public class ClassRoom {
    private final String name;
    private Teacher teacher;
    private Student[] students = new Student[15];

    public ClassRoom(String name, Teacher teacher, Student[] students) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public Student[] getStudents() {
        return students;
    }

}
