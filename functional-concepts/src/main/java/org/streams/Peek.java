package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;

import java.util.List;

public class Peek {
    /**
     * Ejercicio 1:
     * Imprime los nombres de todos los estudiantes del curso de "Java Programming" utilizando peek().
     * <p>
     * Ejercicio 2:
     * Imprime las direcciones de correo electrónico de todos los estudiantes mayores de 25 años en cualquier curso usando peek().
     * <p>
     * Ejercicio 3:
     * Muestra en la consola el nombre de cada curso y la cantidad de estudiantes que tiene, utilizando peek().
     * <p>
     * Ejercicio 4:
     * Imprime el nombre y la edad de todos los estudiantes del curso "UI/UX Design" utilizando peek().
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Course> courses = Factory.buildCoursesAndStudents();
        exercise1(courses);
        exercise2(courses);
        exercise3(courses);
        exercise4(courses);
    }

    private static void exercise1(List<Course> courses) {
        List<Course> list = courses.stream()
                .filter(course -> "Java Programming".equals(course.getName()))
                .peek(course -> course.getStudents().stream()
                        .peek(Student::getName))
                .toList();
    }

    private static void exercise2(List<Course> courses) {
        List<Course> coursesList = courses.stream()
                .peek(Course::getName)
                .peek(course -> course.getStudents().size())
                .toList();
    }

    private static void exercise3(List<Course> courses) {
        List<Course> coursesList = courses.stream()
                .filter(course -> "UI/UX Design".equals(course.getName()))
                .peek(Course::getName)
                .peek(course -> course.getStudents().size())
                .toList();
    }

    private static void exercise4(List<Course> courses) {
        List<Student> coursesList = courses.stream()
                .filter(course -> "UI/UX Design".equals(course.getName()))
                .flatMap(course -> course.getStudents().stream()
                        .peek(Student::getName).peek(Student::getAge))
                .toList();
    }

}
