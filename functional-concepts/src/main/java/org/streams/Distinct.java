package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Distinct {
    /**
     * Ejercicio 1:
     * Obtén una lista de todas las edades distintas de los estudiantes en todos los cursos.
     *
     * Ejercicio 2:
     * Obtén una lista de todos los nombres de cursos distintos.
     *
     * Ejercicio 3:
     * Obtén una lista de todos los estudiantes con direcciones de correo electrónico únicas en todos los cursos.
     *
     * Ejercicio 4:
     * Obtén una lista de todos los estudiantes cuyos nombres sean únicos en todos los cursos.
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
    }
    private static void exercise1(List<Course> courses) {
        List<Integer> coursesList = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .map(Student::getAge)
                .distinct().toList();

        System.out.println(coursesList);

    }
    private static void exercise2(List<Course> courses) {
        List<String> coursesList = courses.stream()
                .map(Course::getName)
                .distinct().toList();
        System.out.println(coursesList);

    }
    private static void exercise3(List<Course> courses) {
        List<Student> studentList= courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .collect(Collectors.groupingBy(Student::getEmail,Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .flatMap(name -> courses.stream()
                        .flatMap(course -> course.getStudents().stream())
                        .filter(student -> student.getName().equals(name)))
                .collect(Collectors.toList());
        System.out.println(studentList);

    }
    private static void exercise4(List<Course> courses) {
        List<Student> studentList= courses.stream()
                .flatMap(course -> course.getStudents().stream())// Aplanamos las listas para devolver una sola lista de estudiantes
                .collect(Collectors.groupingBy(Student::getName, Collectors.counting()))//agrupamos por nombres y contamos cuantas veces se repite
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)//filtramos por aquellos que solo eten una vez
                .map(Map.Entry::getKey)
                .flatMap(name -> courses.stream()
                        .flatMap(course -> course.getStudents().stream())// aplanamos a una lista de de estudiantes de la lista que recibimos por parametro
                        .filter(student -> student.getName().equals(name)))//filtramos por los nombres para devolver una nueva lista con aquellos nombres que esten en la agrupacion
                .collect(Collectors.toList());
        System.out.println(studentList);

    }

}
