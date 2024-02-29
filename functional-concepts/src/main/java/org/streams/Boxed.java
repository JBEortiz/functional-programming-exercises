package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Boxed {
    /**
     * Ejercicio 1:
     * Crea un IntStream que contenga las edades de todos los estudiantes y luego conviértelo
     * a un Stream<Integer> utilizando boxed().
     *
     * Ejercicio 2:
     * Encuentra la edad máxima entre todos los estudiantes en todos los cursos utilizando boxed().
     *
     * Ejercicio 3:
     * Calcula la edad promedio de los estudiantes en el curso de Desarrollo Web utilizando boxed().
     *
     * Ejercicio 4:
     * Crea un DoubleStream que contenga las edades de los estudiantes mayores de 25 años
     * y luego conviértelo a un Stream<Double> utilizando boxed().
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
        Stream<Integer> allAges = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .mapToInt(Student::getAge)
                .boxed();
        System.out.println(allAges);
    }
    private static void exercise2(List<Course> courses) {
       Integer haveStudent = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .mapToInt(Student::getAge)
                .boxed()
                .max(Integer::compareTo).get();
        System.out.println(haveStudent);

    }
    private static void exercise3(List<Course> courses) { //no boxes
       OptionalDouble haveStudent = courses.stream()
                .filter(course -> "Desarrollo Web".equals(course.getName()))
                .flatMap(course -> course.getStudents().stream())
                .mapToInt(Student::getAge)
                .average();
        System.out.println(haveStudent);
    }

    private static void exercise4(List<Course> courses) {
        List<Double> haveStudent = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student-> student.getAge()>25)
                .mapToDouble(Student::getAge)
                .boxed()
                .toList();
        System.out.println(haveStudent);
    }
}
