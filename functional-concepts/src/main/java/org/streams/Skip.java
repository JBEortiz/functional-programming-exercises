package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Skip {
    /**
     * Ejercicio 1:
     * Salta el primer estudiante en el curso "Java Programming" y muestra los estudiantes restantes.
     *
     * Ejercicio 2:
     * Salta el primer estudiante en cada curso y muestra los estudiantes restantes.
     *
     * Ejercicio 3:
     * Salta los primeros 2 estudiantes menores de 25 años en cada curso y muestra los estudiantes restantes.
     *
     */
    public static void main(String[] args) {
        List<Course> courses = Factory.buildCoursesAndStudents();

        exercise1(courses);
        exercise2(courses);
        exercise3(courses);
    }
    private static void exercise1(List<Course> courses) {
        courses.stream()
                .filter(course -> "Java Programming".equals(course.getName()))
                .flatMap(course -> course.getStudents().stream())
                .skip(1)
                .forEach(System.out::println);

    }
    private static void exercise2(List<Course> courses) {
        courses.stream()
                .map(course -> {
                    List<Student> studentsAfterSkippingFirst = course.getStudents().stream()
                            .skip(1)
                            .toList();

                    return Course.builder().name(course.getName()).students(studentsAfterSkippingFirst).build();
                })
                .forEach(course -> {
                    System.out.println("Curso: " + course.getName());
                    course.getStudents().forEach(student ->
                            System.out.println("    Estudiante: " + student.getName()));
                });

    }

    private static void exercise3(List<Course> courses) {
        courses.stream()
                .map(course -> {
                    List<Student> studentsAfterSkippingFirst = course.getStudents().stream()
                            .filter(student -> student.getAge()<25)
                            .skip(2)
                            .toList();

                    return Course.builder().name(course.getName()).students(studentsAfterSkippingFirst).build();
                })
                .forEach(course -> {
                    System.out.println("Curso: " + course.getName());
                    course.getStudents().forEach(student ->
                            System.out.println("    Estudiante: " + student.getName()));
                });
    }
}
