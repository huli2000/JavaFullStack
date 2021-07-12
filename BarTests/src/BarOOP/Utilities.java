package BarOOP;
public class Utilities {

    protected static String getRandomProfession() {
        String[] professions = {"math", "chemistry", "geography", "literature", "physics", "sports"};
        int index = (int) (Math.random() * professions.length);
        return professions[index];
    }

    protected static int getRandomNum(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    protected static Grade[] getRandomGrades() {
        Grade[] grades = new Grade[6];
        for (int i = 0; i < grades.length; i++) {
            grades[i] = new Grade(getRandomNum(40, 100), getRandomProfession());
        }
        return grades;
    }

    protected static int classTotalScore(ClassRoom classRoom) {
        int total = 0;

        for (Student student : classRoom.getStudents()) {
            total += studentTotalScore(student);
        }
        return total;
    }

    protected static int studentTotalScore(Student student) {
        int total = 0;
        for (Grade grade : student.getGrades()) {
            total += grade.getScore();
        }
        return total;
    }
}
