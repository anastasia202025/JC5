package org.example;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            students.add(new Student(getName(), getSubject()));
        }

        for (Student student : students) {
            Random rnd = new Random();
            for (int i = 0; i < 3; i++) {
                student.setGrade(rnd.nextInt(3, 6));
            }
            System.out.println(
                    student.getName() + ": " +
                            student.getSpecialty() + " - " +
                            student.getGrades() + " AverageGrade: " +
                            String.format("%.2f", student.getAverageGrade())
            );
        }

        /* Найдите первых 5 студентов специальности "Информатика"
        с средним баллом выше 4.5, отсортированных по убыванию среднего балла. */
        var firstFiveStudents = students.stream()
                .filter(student -> Objects.equals(student.getSpecialty(), "Информатика"))
                .filter(student -> student.getAverageGrade() > 4.5)
                .sorted((student2,
                         student1) -> student1.getAverageGrade().compareTo(student2.getAverageGrade()))
                .limit(5)
                .toList();

        System.out.println(
                firstFiveStudents.stream()
                        .map(student -> "%s - %s".formatted(
                                student.getName(),
                                String.format("%.2f", student.getAverageGrade())))
                        .collect(Collectors.toList())
        );


    }

    private static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    private static String getSubject() {
        return Subjects.values()[new Random().nextInt(Subjects.values().length)].toString();
    }

}
