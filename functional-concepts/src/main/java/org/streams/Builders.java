package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Course;
import org.streams.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Builders {
    /**
     * Ejercicio 1:
     * Crea un nuevo curso llamado "Data Science" utilizando el patrón builder().
     * Agrega al menos dos estudiantes a este curso.
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Course> courses = Factory.buildCoursesAndStudents();
        exercise1(courses);
    }
    private static void exercise1(List<Course> courses) {
        Stream.Builder<Course> courseStreamBuilder = Stream.builder();
        List<Student> studentList= new ArrayList<>();
        studentList.add(Student.builder().name("Pedro").age(25).email("Pedro@example.com").build());
        studentList.add(Student.builder().name("Peke").age(28).email("Peke@example.com").build());

        courseStreamBuilder.accept(Course.builder().name("Data Science")
                .students(studentList)
                .build());

        Stream<Course> courseStream = courseStreamBuilder.build();
        courseStream.forEach(System.out::println);

    }
}
