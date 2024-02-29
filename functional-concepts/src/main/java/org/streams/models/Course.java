package org.streams.models;

import lombok.Builder;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@ToString
@Builder
public class Course {
    private String name;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }
    public Course(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }
}
