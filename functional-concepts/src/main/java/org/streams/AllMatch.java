package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;

import java.util.List;

public class AllMatch {

    /**
     * Ejercicio 1:
     * Verifica si todos los cursos tienen al menos un estudiante.
     *
     * Ejercicio 2:
     * Verifica si todos los estudiantes de todos los cursos son mayores de 20 años.
     *
     * Ejercicio 3:
     * Verifica si todos los estudiantes de Diseño de UI/UX Design tienen un correo electrónico que contiene "@example.com".
     *
     * Ejercicio 4:
     * Verifica si todos los cursos tienen al menos un estudiante cuyo nombre comienza con la letra "J".
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
       boolean haveStudent= courses.stream()
               .allMatch(course-> !course.getStudents().isEmpty());
       System.out.println(haveStudent);
    }

    private static void exercise2(List<Course> courses) {
        boolean haveStudent= courses.stream()
                .allMatch(course-> course.getStudents().stream()
                        .allMatch(estudent->estudent.getAge()>20));
        System.out.println(haveStudent);
    }

    private static void exercise3(List<Course> courses) {
        boolean haveStudent= courses.stream()
                .filter(course-> "UI/UX Design".equals(course.getName()))
                .allMatch(course-> course.getStudents().stream()
                        .allMatch(estudent->estudent.getEmail().contains("@example.com")));
        System.out.println(haveStudent);

        boolean allStudentsHaveExampleEmail = courses.stream()
                .filter(course -> "UI/UX Design".equals(course.getName()))
                .flatMap(course -> course.getStudents().stream())
                .allMatch(student -> student.getEmail().contains("@example.com"));
        System.out.println(allStudentsHaveExampleEmail);
    }

    private static void exercise4(List<Course> courses) {

        boolean haveStudent= courses.stream()
                .allMatch(course-> course.getStudents().stream()
                        .allMatch(estudent->estudent.getName().startsWith("J")));
        System.out.println(haveStudent);

    }
}
