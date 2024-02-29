package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;

import java.util.*;
import java.util.stream.Collectors;

public class FindFirst {
    /**
     * Ejercicio 1:
     * Encontrar el primer curso con un estudiante específico por nombre "Bob".
     *
     * Ejercicio 2:
     * Obtener el correo electrónico del estudiante más joven de todos los cursos.
     *
     * Ejercicio 3:
     * Encontrar el primer estudiante mayor de 30 años y mostrar su nombre y curso.
     *
     * Ejercicio 4:
     * Encuentra los estudiantes más jovenes en todos los cursos y muestra su nombre, edad y el nombre del curso en el que está inscrito.
     */
    public static void main(String[] args) {
        List<Course> courses = Factory.buildCoursesAndStudents();
        exercise1(courses);
        exercise2(courses);
        exercise3(courses);
        exercise4(courses);
    }
    private static void exercise1(List<Course> courses) {

        Optional<Course> studentOptional = courses.stream()
                .filter(course -> course.getStudents().stream()
                        .anyMatch(student -> "Bob".equals(student.getName()))
                ).findFirst();
        System.out.println(studentOptional);
    }
    private static void exercise2(List<Course> courses) {
        Optional<String> coursesList = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .min(Comparator.comparingInt(Student::getAge))
                .map(Student::getName)
                .stream().findFirst();
        System.out.println(coursesList);
    }
    private static void exercise3(List<Course> courses) {
        Map<String,String> coursesList = courses.stream()
                .filter(course -> course.getStudents().stream().anyMatch(student -> student.getAge()>30))
                        .collect(Collectors
                                .toMap(Course::getName,
                                        course1-> course1.getStudents().stream()
                                                .map(Student::getName)
                                                .findFirst().orElse("")
                ));
        System.out.println(coursesList);
    }
    private static void exercise4(List<Course> courses) {
        Map<String, String> coursesList = courses.stream()
                .collect(Collectors
                        .toMap(Course::getName,
                                course1-> course1.getStudents().stream()
                                        .min(Comparator.comparingInt(Student::getAge))
                                        .map(student -> student.getName()+ " Age:"+student.getAge()).get()
                        ));
        System.out.println(coursesList);
    }

}
