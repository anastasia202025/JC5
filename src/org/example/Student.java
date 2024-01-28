package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Student {
    private String name;
    private List<Double> grades = new ArrayList<>();
    private String specialty;

    public Student(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrade(Integer grade) {
        this.grades.add(grade * 1.0);
    }

    public Double getAverageGrade() {
        Optional<Double> sum = this.grades.stream().reduce(Double::sum);
        return sum.map(aDouble -> aDouble / this.grades.size()).orElse(0.0);
    }
}
