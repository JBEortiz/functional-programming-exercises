package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;

import java.util.ArrayList;
import java.util.List;

public class Concat {
    /**
     * Ejercicio 1:
     * Crea una nueva lista que contenga todos los estudiantes del curso de Programación Java y del curso de Desarrollo Web.
     *
     * Ejercicio 2:
     * Crea una nueva lista que contenga todos los cursos del área de tecnología (Machine Learning, UI/UX Design, y Cybersecurity).
     *
     * Ejercicio 3:
     * Crea una nueva lista que contenga todos los estudiantes de todos los cursos.
     *
     * Ejercicio 4:
     * Crea una nueva lista que contenga todos los cursos  pero duplica todos los estudiantes del curso de Machine Learning.
     */

    public static void main(String[] args) {
        List<Course> courses = Factory.buildCoursesAndStudents();

        exercise1(courses);
        exercise2(courses);
        exercise3(courses);
        exercise4(courses);
        exercise5(courses);
    }

    private static void exercise1(List<Course> courses) {
        List<Student> studentList= new ArrayList<>();
        courses.stream()
                .filter(course -> course.getName().equals("Machine Learning") || course.getName().equals("Web Development"))
                .flatMap(course -> course.getStudents().stream())
                .forEach(studentList::add);
        System.out.println(studentList);

    }
    private static void exercise2(List<Course> courses) {
        List<Course> coursesList = courses.stream()
                .filter(course -> course.getName().equals("Machine Learning") || course.getName().equals("UI/UX Design")|| course.getName().equals("Cybersecurity"))
                .toList();
        System.out.println(coursesList);

    }
    private static void exercise3(List<Course> courses) {
        Integer studentCount= Math.toIntExact(courses.stream()
                .filter(course -> course.getName().equals("Machine Learning") && course.getStudents().stream()
                        .anyMatch(student -> student.getAge()>=28))
                .count());
        System.out.println(studentCount);

    }
    private static void exercise4(List<Course> courses) {
        List<Student> studentCount = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                        .toList();
        System.out.println(studentCount);

    }
    private static void exercise5(List<Course> courses) {
        List<Course> duplicatedMachineLearningStudents = new ArrayList<>(courses);
        List<Student> machineLearningStudents = courses.get(2).getStudents();
        duplicatedMachineLearningStudents.get(2).getStudents().addAll(machineLearningStudents);
        System.out.println("Cursos y estudiantes con duplicación en Machine Learning: " + duplicatedMachineLearningStudents);


    }
}
