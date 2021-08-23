package BarOOP;

import java.util.Arrays;

public class SchoolStatistics {
    public static void main(String[] args) {
        //Create school with classes,teacher and students
        School school = new School(generateClassRooms());

        //Part1: school average
        schoolAverage(school);

        //Part2: class average
        classAverage(school.getClassRooms());

        //Part3: school average per profession
        schoolAveragePerProfession(school);

        //Bonus3: students age average
        studentsAgeAverage(school);

    }


    private static void schoolAverage(School school) {
        int totalScore = 0;
        int totalGrades = 0;

        for (ClassRoom classRoom : school.getClassRooms()) {
            totalScore += Utilities.classTotalScore(classRoom);
            totalGrades += classRoom.getStudents().length * 6;
        }
        System.out.println("The school average is: " + (totalScore / totalGrades));
    }

    private static void classAverage(ClassRoom[] classRooms) {

        for (ClassRoom classRoom : classRooms) {
            int totalScore = 0;
            for (Student student : classRoom.getStudents()) {
                totalScore += Utilities.studentTotalScore(student);
            }
            System.out.println("Class name: " + classRoom.getName() +
                    " Class average " + totalScore / (classRoom.getStudents().length * 6));
        }
    }

    private static void schoolAveragePerProfession(School school) {
        int totalMath, totalChemistry, totalGeography,
                totalLiterature, totalPhysics, totalSports;
        totalMath = totalChemistry = totalGeography
                = totalLiterature = totalPhysics = totalSports = 0;

        int countMath, countChemistry, countGeography,
                countLiterature, countPhysics, countSports;
        countMath = countChemistry = countGeography
                = countLiterature = countPhysics = countSports = 0;

        for (ClassRoom classRoom : school.getClassRooms()) {
            for (Student student : classRoom.getStudents()) {
                for (Grade grade : student.getGrades()) {
                    switch (grade.getProfession()) {
                        case "math" -> {
                            totalMath += grade.getScore();
                            countMath++;
                        }
                        case "chemistry" -> {
                            totalChemistry += grade.getScore();
                            countChemistry++;
                        }
                        case "geography" -> {
                            totalGeography += grade.getScore();
                            countGeography++;
                        }
                        case "literature" -> {
                            totalLiterature += grade.getScore();
                            countLiterature++;
                        }
                        case "physics" -> {
                            totalPhysics += grade.getScore();
                            countPhysics++;
                        }
                        case "sports" -> {
                            totalSports += grade.getScore();
                            countSports++;
                        }
                    }
                }
            }
        }
        System.out.println("math: " + totalMath / countMath
                + "\nchemistry: " + totalChemistry / countChemistry
                + "\ngeography: " + totalGeography / countGeography
                + "\nliterature: " + totalLiterature / countLiterature
                + "\nphysics: " + totalPhysics / countPhysics
                + "\nsports: " + totalSports / countSports);
    }

    private static void studentsAgeAverage(School school) {
        int totalAge = 0;
        int totalStudent = 0;
        for (ClassRoom classroom : school.getClassRooms()) {
            for (Student student : classroom.getStudents()) {
                totalStudent++;
                totalAge += student.getAge();
            }
        }
        System.out.println("The total students age average is: " + totalAge / totalStudent);
    }

    private static ClassRoom[] generateClassRooms() {
        ClassRoom[] classRooms = new ClassRoom[5];
        Teacher[] teachers = generateTeachers();

        for (int i = 0; i < classRooms.length; i++) {
            Student[] students = generateStudents();
            classRooms[i] = new ClassRoom("class" + i, teachers[i], students);
        }
        return classRooms;
    }

    private static Student[] generateStudents() {
        Student[] students = new Student[15];
        for (int i = 0; i < students.length; i++) {
            Grade[] grades = Utilities.getRandomGrades();
            students[i] = new Student("Student" + i, Utilities.getRandomNum(20, 120), grades);
        }
        return students;
    }

    private static Teacher[] generateTeachers() {
        Teacher[] teachers = new Teacher[6];
        for (int i = 0; i < teachers.length; i++) {
            teachers[i] = new Teacher("Teacher" + i,
                    Utilities.getRandomNum(20, 120), Utilities.getRandomProfession());
        }
        System.out.println(Arrays.toString(teachers));
        return teachers;
    }
}
