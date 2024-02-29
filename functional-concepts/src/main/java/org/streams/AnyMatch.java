package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;

import java.util.List;


public class AnyMatch {

    /**
     * Ejercicio 1:
     * Verifica si hay al menos un estudiante mayor de 30 años.
     *
     * Ejercicio 2:
     * Verifica si hay al menos un estudiante cuyo nombre contiene la letra "a".
     *
     * Ejercicio 3:
     * Verifica si hay al menos un curso con más de 3 estudiantes.
     *
     * Ejercicio 4:
     * Verifica si hay al menos un curso que tiene estudiantes menores de 25 años.
     *
     * Ejercicio 5:
     * Dada la lista de cursos y estudiantes, encuentra el nombre del curso que tiene al menos un estudiante mayor de 25 años
     * y cuyo nombre del estudiante contiene la letra "a".
     * Si no hay ninguno, devuelve "Ningún curso cumple con los criterios".
     * @param args
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
        boolean haveStudent= courses.stream()
                .anyMatch(course-> course.getStudents().stream()
                        .anyMatch(student -> student.getAge()>30));
        System.out.println(haveStudent);

        boolean haveStudentFlapMap= courses.stream()
                .flatMap(course-> course.getStudents().stream())
                .anyMatch(student -> student.getAge()>30);
        System.out.println(haveStudentFlapMap);
    }
    private static void exercise2(List<Course> courses) {
        boolean haveStudent= courses.stream()
                .anyMatch(course-> course.getStudents().stream()
                        .anyMatch(student -> student.getName().contains("a")));
        System.out.println(haveStudent);

        boolean haveStudentFlapMap= courses.stream()
                .flatMap(course-> course.getStudents().stream())
                .anyMatch(student -> student.getName().contains("a"));
        System.out.println(haveStudentFlapMap);
    }
    private static void exercise3(List<Course> courses) {
        boolean haveStudent= courses.stream()
                .anyMatch(course-> course.getStudents().size()>3);
        System.out.println(haveStudent);
    }

    private static void exercise4(List<Course> courses) {
        boolean haveStudent=   courses.stream()
                .anyMatch(course -> course.getStudents().stream()
                        .anyMatch(student -> student.getAge() < 25));
        System.out.println(haveStudent);
    }
    private static void exercise5(List<Course> courses) {

        String haveStudent=   courses.stream()
                .filter(course -> course.getStudents().stream()
                        .anyMatch(student -> student.getAge() < 25 && student.getName().contains("a")))
                .map(Course::getName)
                .findFirst().orElse("Ningún curso cumple con los criterios");
        System.out.println(haveStudent);
    }

}
