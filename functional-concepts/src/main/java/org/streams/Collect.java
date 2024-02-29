package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * Ejercicio 1:
 * Obtén una lista con los nombres de todos los estudiantes de todos los cursos.
 *
 * Ejercicio 2:
 * Crea un Map donde la clave sea el nombre del curso y el valor sea la edad promedio de los estudiantes de ese curso.
 *
 * Ejercicio 3:
 * Agrupa a los estudiantes por rango de edad (por ejemplo, 20-25, 26-30, etc.) y muestra la cantidad de estudiantes en cada rango.
 *
 * Ejercicio 4:
 * Obtén una lista con todos los estudiantes cuyos nombres empiezan con la letra "J".
 *
 * Ejercicio 5:
 * Crea un Map donde la clave sea el nombre del curso y el valor sea una lista de estudiantes que tienen menos de 25 años.
 */
public class Collect {

    public static void main(String[] args) {
        List<Course> courses = Factory.buildCoursesAndStudents();

        exercise1(courses);
        exercise2(courses);
        exercise3(courses);
        exercise4(courses);
        exercise5(courses);
    }
    private static void exercise1(List<Course> courses) {
        List<String> nameListAllCourse= courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .map(Student::getName)
                .toList();
        System.out.println(nameListAllCourse);

    }
    private static void exercise2(List<Course> courses) {
        Map<String, Double> courseMap= courses.stream().collect(Collectors.toMap(Course::getName,
                course -> course.getStudents().stream()
                        .mapToInt(Student::getAge)
                        .average()
                        .orElse(0.0)));

        System.out.println(courseMap);
    }

    private static void exercise3(List<Course> courses) {
        Map<String, Long> courseMap= courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .collect(Collectors.groupingBy(
                        student ->{
                             int age= student.getAge();
                             if (age>=20 && age<=25) return "20-25";
                             if (age>=26 && age<=30) return "26-30";
                             if(age<30) return "30>";
                            return "20<";
                        }, Collectors.counting()));
        System.out.println(courseMap);
    }

    private static void exercise4(List<Course> courses) {
        List<String> nameListAllName=courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> student.getName().startsWith("j"))
                .map(Student::getName)
                .toList();
        System.out.println(nameListAllName);
    }

    private static void exercise5(List<Course> courses) {
        Map<String, List<Student>> courseMap=courses.stream()
                .collect(Collectors.toMap(Course::getName,
                        course -> course.getStudents().stream()
                                .filter(student -> student.getAge()>25)
                                .toList())
                        );
        System.out.println(courseMap);
    }

}
