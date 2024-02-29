package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class FlatMap {
    /**
     * Ejercicio 1:
     * Obtener una lista de todos los nombres de estudiantes en todos los cursos.
     *
     * Ejercicio 2:
     * Obtener una lista de todos los correos electrónicos de estudiantes mayores de 25 años.
     *
     * Ejercicio 3:
     * Crear un mapa donde la clave sea el nombre del curso y el valor sea la lista de estudiantes de ese curso.
     *
     * Ejercicio 4:
     * Obtener una lista de todos los datos adicionales de estudiantes en cursos de desarrollo web.
     *
     * Ejercicio 5:
     * Obtener la edad promedio de todos los estudiantes en todos los cursos.
     *
     * Ejercicio 6:
     * Obtener la suma de las edades de todos los estudiantes en cursos de ciberseguridad.
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
    }

    private static void exercise1(List<Course> courses) {
        List<String> studentList= courses.stream()
                        .flatMap(course -> course.getStudents().stream())
                                .map(Student::getName)
                                        .toList();
        System.out.println(studentList);
    }
    private static void exercise2(List<Course> courses) {
        List<String> studentList= courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> student.getAge()>25)
                .map(Student::getEmail)
                .toList();
        System.out.println(studentList);
    }
    private static void exercise3(List<Course> courses) {
        Map<String, List<Student>> studentList= courses.stream()
                .collect(Collectors.toMap(Course::getName, course -> course.getStudents()));
        System.out.println(studentList);
    }

    private static void exercise4(List<Course> courses) {
        List<String> studentList= courses.stream()
                .filter(course -> "Web Development".equals(course.getName()))
                .flatMap(course -> course.getStudents().stream())
                .map(student -> student.getAdditionalInfo().getSomeInfo())
                .toList();
        System.out.println(studentList);
    }
    private static void exercise5(List<Course> courses) {

        OptionalDouble averageAgeStudent= courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .mapToDouble(Student::getAge)
                .average();
        System.out.println(averageAgeStudent);
    }

    private static void exercise6(List<Course> courses) {

        double averageAgeStudent= courses.stream()
                .filter(course -> "Cybersecurity".equals(course.getName()))
                .flatMap(course -> course.getStudents().stream())
                .mapToDouble(Student::getAge)
                .sum();
        System.out.println(averageAgeStudent);
    }
}