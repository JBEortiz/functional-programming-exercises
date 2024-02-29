package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {
    /**
     * Ejercicio 1:
     * Filtra los cursos que tengan al menos un estudiante mayor de 25 años.
     *
     * Ejercicio 2:
     * Filtra los estudiantes que tengan una dirección de correo electrónico que contenga la cadena "@example.com".
     *
     * Ejercicio 3:
     * Filtra los cursos que tengan más de dos estudiantes.
     *
     * Ejercicio 4:
     * Filtra los estudiantes cuyos nombres comiencen con la letra "J".
     *
     * Ejercicio 5:
     * Filtra los cursos que tengan al menos un estudiante cuyo nombre sea "Alice".
     *
     * Ejercicio 6:
     * Filtra los estudiantes que tengan una edad entre 23 y 28 años.
     *
     * Ejercicio 7:
     * Filtra los cursos que tengan estudiantes mayores de 30 años.
     *
     * Ejercicio 8:
     * Filtra los estudiantes que tengan una dirección de correo electrónico que termine con ".com".
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
        exercise8(courses);
    }
    private static void exercise1(List<Course> courses) {
        List<Course> coursesList = courses.stream()
                .filter(course -> course.getStudents().stream()
                        .anyMatch(student -> student.getAge()>25)).toList();
        System.out.println(coursesList);
    }
    private static void exercise2(List<Course> courses) {
        List<Course> coursesList = courses.stream()
                .filter(course -> course.getStudents().stream().allMatch(student -> student.getEmail().contains("@example.com")))
                                .toList();
        System.out.println(coursesList);
    }
    private static void exercise3(List<Course> courses) {
        List<Course> coursesList = courses.stream()
                .filter(course -> course.getStudents().size()>2)
                        .toList();

        System.out.println(coursesList);
    }

    private static void exercise4(List<Course> courses) {
        List<Student> coursesList = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> student.getName().toLowerCase().startsWith("j"))
                .toList();
        System.out.println(coursesList);
    }
    private static void exercise5(List<Course> courses) {
        List<Course> coursesList = courses.stream()
                .filter(course -> course.getStudents().stream()
                        .anyMatch(student ->  "Alice".equals(student.getName())))
                .toList();
        System.out.println(coursesList);
    }
    private static void exercise6(List<Course> courses) {
        List<Student> coursesList = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> student.getAge()>=23 && student.getAge()<=28)
                .toList();
        System.out.println(coursesList);
    }

    private static void exercise7(List<Course> courses) {
        List<Course> coursesList = courses.stream()
                .filter(course -> course.getStudents().stream()
                        .anyMatch(student -> student.getAge()>30))
                .toList();
        System.out.println(coursesList);
    }
    private static void exercise8(List<Course> courses) {
        List<Student> coursesList = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> student.getEmail().toLowerCase().endsWith(".com"))
                .toList();
        System.out.println(coursesList);
    }
}
