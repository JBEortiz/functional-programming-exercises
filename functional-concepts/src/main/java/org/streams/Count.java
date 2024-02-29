package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Count {
    /**
     * Ejercicio 1:
     * Cuenta el número total de estudiantes en todos los cursos.
     *
     * Ejercicio 2:
     * Cuenta el número de cursos que tienen al menos un estudiante con edad menor a 25 años.
     *
     * Ejercicio 3:
     * Cuenta el número de estudiantes en el curso de "Machine Learning" que tienen una edad mayor o igual a 28 años.
     *
     * Ejercicio 4:
     * Cuenta el número de cursos en los que todos los estudiantes tienen una dirección de correo electrónico que termina con ".com".
     *
     * Ejercicio 5:
     * Cuenta el número de estudiantes que tienen un nombre que contiene la letra "a" en todos los cursos.
     *
     *
     * @param args
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
        Integer studentCount= Math.toIntExact(courses.stream()
                .flatMap(course -> course.getStudents().stream()).count());
        System.out.println(studentCount);

    }
    private static void exercise2(List<Course> courses) {
        Integer studentCount= Math.toIntExact(courses.stream()
                .filter(course -> course.getStudents().stream()
                        .anyMatch(student -> student.getAge()<25))
                .count());
        System.out.println(studentCount);

    }
    private static void exercise3(List<Course> courses) {
        Integer studentCount= Math.toIntExact(courses.stream()
                .filter(course -> course.getName().equals("Machine Learning") && course.getStudents().stream()
                        .anyMatch(student -> student.getAge()>=28))
                .count());
        System.out.println(studentCount);

    }
    private static void exercise4(List<Course> courses) {
        long studentCount = courses.stream()
                .flatMap(course -> course.getStudents().stream().filter(student -> student.getEmail().endsWith(".com"))
                        )
                .count();
        System.out.println(studentCount);

    }
    private static void exercise5(List<Course> courses) {
        long studentCount = courses.stream()
                .flatMap(course -> course.getStudents().stream()
                        .filter(student -> student.getName().toLowerCase().contains("a")))
                .count();
        System.out.println(studentCount);

    }
}
