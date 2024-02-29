package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapToDouble {
    /**
     *Ejercicio 1:
     * Calcula el promedio de las edades de todos los estudiantes en todos los cursos utilizando mapToDouble().
     *
     * Ejercicio 2:
     * Obtén un DoubleStream que contenga las edades de todos los estudiantes del curso "Java Programming"
     * y calcula la suma utilizando mapToDouble().
     *
     * Ejercicio 3:
     * Crea un DoubleStream con las edades de los estudiantes mayores de 25 años en todos los cursos y
     * calcula su promedio usando mapToDouble().
     *
     * Ejercicio 4:
     * Calcula la suma de las edades de todos los estudiantes en el curso "UI/UX Design" utilizando mapToDouble().
     *
     * Ejercicio 5:
     * Crea un DoubleStream con las edades de los estudiantes cuyos nombres comienzan con "J"
     * en cualquier curso y calcula su promedio con mapToDouble().
     *
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
        double averageAge = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .mapToDouble(Student::getAge)
                .average()
                .orElse(0);
        System.out.println(averageAge);
    }
    private static void exercise2(List<Course> courses) {
        double sumOfAgesJavaProgramming = courses.stream()
                .filter(course -> course.getName().equals("Java Programming"))
                .flatMap(course -> course.getStudents().stream())
                .mapToDouble(Student::getAge)
                .sum();
        System.out.println(sumOfAgesJavaProgramming);
    }
    private static void exercise3(List<Course> courses) {
        double averageAgeOver25 = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> student.getAge() > 25)
                .mapToDouble(Student::getAge)
                .average()
                .orElse(0);
    }
    private static void exercise4(List<Course> courses) {
        double averageAgeOver25 = courses.stream()
                .filter(course -> "UI/UX Design".equals(course.getName()))
                .flatMap(course -> course.getStudents().stream())
                        .mapToDouble(Student::getAge)
                                .sum();
        System.out.println(averageAgeOver25);
    }
    private static void exercise5(List<Course> courses) {
        double averageAgeOver25 = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> student.getName().startsWith("J"))
                .mapToDouble(Student::getAge)
                .average()
                .orElse(0);
    }
}
