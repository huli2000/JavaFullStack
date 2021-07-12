package BarOOP;
public class School {
    private ClassRoom[] classRooms = new ClassRoom[5];

    public School(ClassRoom[] classRooms) {
        this.classRooms = classRooms;
    }

    public ClassRoom[] getClassRooms() {
        return classRooms;
    }


}
