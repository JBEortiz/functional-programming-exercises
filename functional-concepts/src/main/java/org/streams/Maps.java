package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.CourseSummary;

import java.util.List;

public class Maps {
    /**
     * Ejercicio 1: Obtén una lista con los nombres de todos los cursos en mayúsculas.
     *
     * Ejercicio 2: Crea una lista con objetos CourseSummary,
     *  donde cada objeto tenga el nombre del curso y la cantidad de estudiantes.
     *
     * Ejercicio 3: Convierte todas las edades de los estudiantes en días
     * (considerando que un año tiene 365 días) y obtén una lista con estas edades en días.
     *
     * Ejercicio 5: Obtén una lista de cadenas que contenga "Nombre del estudiante
     * - Edad" para todos los estudiantes en todos los cursos.
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
        List<String> nameCourse = courses.stream()
                .map(course -> course.getName().toUpperCase())
                .toList();
        System.out.println(nameCourse);
    }

    private static void exercise2(List<Course> courses) {
        List<CourseSummary> studentCourseNames = courses.stream()
                .map(course -> {
                    CourseSummary courseSummary= new CourseSummary();
                    courseSummary.setNameCourse(course.getName());
                    courseSummary.setSizeStudents(course.getStudents().size());
                    return courseSummary;
                })
                .toList();
        studentCourseNames.forEach(System.out::println);
    }

    private static void exercise3(List<Course> courses) {
        List<Integer> coursesList = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .map(student ->  student.getAge()*365)
                .toList();
        System.out.println(coursesList);
    }

    private static void exercise4(List<Course> courses) {
        List<String> coursesList = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                        .map(student -> {
                            return student.getName() +"-"+ student.getAge();
                        })
                .toList();
        System.out.println(coursesList);
    }

}
