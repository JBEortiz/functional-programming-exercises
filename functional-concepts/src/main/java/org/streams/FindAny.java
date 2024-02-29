package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;

import java.util.List;
import java.util.Optional;

public class FindAny {
    /**
     * Ejercicio 1:
     * Encuentra cualquier estudiante mayor de 28 años.
     *
     * Ejercicio 2:
     * Encuentra cualquier curso que tenga al menos dos estudiantes.
     *
     * Ejercicio 3:
     * Encuentra cualquier estudiante cuyo nombre sea "Charlie".
     *
     * Ejercicio 4:
     * Encuentra cualquier curso que tenga al menos un estudiante menor de 25 años.
     *
     * Ejercicio 5:
     * Encuentra cualquier estudiante cuya dirección de correo electrónico termine con ".com".
     *
     * Ejercicio 6:
     * Encuentra cualquier curso que tenga al menos un estudiante con una edad exacta de 23 años.
     *
     * Ejercicio 7:
     * Encuentra cualquier estudiante que sea mayor de 25 años,
     * tenga una dirección de correo electrónico que contenga la cadena "example",
     * y su nombre comience con la letra "J".
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
        exercise6(courses);
        exercise7(courses);
    }
    private static void exercise1(List<Course> courses) {
        Optional<Student> studentOptional = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                        .filter(student -> student.getAge()>28).findAny();
        System.out.println(studentOptional);
    }
    private static void exercise2(List<Course> courses) {
        List<Course> coursesList = courses.stream()
                .filter(course -> course.getStudents().size()>2)
                .toList();
        System.out.println(coursesList);
    }
    private static void exercise3(List<Course> courses) {
        Optional<Student> studentOptional  = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> "Charlie".equals(student.getName()))
                .findAny();

        System.out.println(studentOptional);
    }
    private static void exercise4(List<Course> courses) {
        Optional<Course> coursesList = courses.stream()
                .filter(course -> course.getStudents().stream()
                        .anyMatch(student -> student.getAge()>25))
                .findAny();
        System.out.println(coursesList);
    }
    private static void exercise5(List<Course> courses) {
        Optional<Student> studentOptional = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> student.getEmail().toLowerCase().endsWith(".com"))
                .findAny();
        System.out.println(studentOptional);
    }
    private static void exercise6(List<Course> courses) {
        Optional<Course> coursesList = courses.stream()
                .filter(course -> course.getStudents().stream()
                        .anyMatch(student -> student.getAge()==23))
                .findAny();
        System.out.println(coursesList);
    }
    private static void exercise7(List<Course> courses) {
        Optional<Student>  studentOptional = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student ->
                        student.getAge()>25 &&
                                student.getName().startsWith("J") &&
                                student.getEmail().contains("example")
                ).findAny();
        System.out.println(studentOptional);
    }

}
