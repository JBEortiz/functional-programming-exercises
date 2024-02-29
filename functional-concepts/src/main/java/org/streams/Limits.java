package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.CourseSummary;
import org.streams.models.Student;

import java.util.List;

public class Limits {
    /**
     * Ejercicio 1:
     * Limita la cantidad de estudiantes a mostrar primer estudiante de cada curso.
     *
     * Ejercicio 2:
     * Limita la cantidad de cursos a mostrar a solo los primeros 3 cursos.
     *
     * Ejercicio 3:
     * Crea un Stream de estudiantes mayores de 25 años y limita la salida a 3 estudiantes.
     *
     */
    public static void main(String[] args) {
        List<Course> courses = Factory.buildCoursesAndStudents();
        exercise1(courses);
        exercise2(courses);
        exercise3(courses);
        exercise4(courses);
    }

    private static void exercise1(List<Course> courses) {
        List<Student> students = courses.stream()
                        .flatMap(course -> course.getStudents().stream())
                                .limit(1)
                .toList();
        System.out.println(students);
    }

    private static void exercise2(List<Course> courses) {
        List<Course> corusesLimit = courses.stream()
                .limit(3)
                .toList();
        System.out.println(corusesLimit);
    }

    private static void exercise3(List<Course> courses) {
        List<Student> students = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student ->  student.getAge()>25)
                .limit(3)
                .toList();
        System.out.println(students);
    }

    private static void exercise4(List<Course> courses) {
        List<Course> coursess = courses.stream()
                .filter(course -> "Web Development".equals(course.getName()))
                .limit(1)
                .toList();

        System.out.println(coursess);
    }

}
