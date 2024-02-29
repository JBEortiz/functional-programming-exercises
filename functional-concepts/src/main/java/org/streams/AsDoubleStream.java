package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;
import java.util.List;
import java.util.OptionalDouble;

public class AsDoubleStream {

    /**
     * Ejercicio 1:
     * Calcula la edad promedio de todos los estudiantes en todos los cursos.
     *
     * Ejercicio 2:
     * Calcula la edad promedio de los estudiantes en el curso de Desarrollo Web.
     *
     * Ejercicio 3:
     * Calcula la edad máxima de todos los estudiantes en todos los cursos.
     *
     * Ejercicio 4:
     * Calcula la edad mínima de los estudiantes en el curso de Machine Learning.
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
      Double haveStudent = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .mapToDouble(Student::getAge)
                .average().getAsDouble();
        System.out.println(haveStudent);
    }
    private static void exercise2(List<Course> courses) {
        Double haveStudent = courses.stream()
                .filter(course -> "Web Development".equals(course.getName()))
                .flatMap(course -> course.getStudents().stream())
                .mapToDouble(Student::getAge)
                .average().getAsDouble();
        System.out.println(haveStudent);

    }
    private static void exercise3(List<Course> courses) {
        Double haveStudent = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .mapToDouble(Student::getAge)
                .max().getAsDouble();
        System.out.println(haveStudent);
    }

    private static void exercise4(List<Course> courses) {
        Double haveStudent = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .mapToDouble(Student::getAge)
                .min().getAsDouble();
        System.out.println(haveStudent);
    }
}
