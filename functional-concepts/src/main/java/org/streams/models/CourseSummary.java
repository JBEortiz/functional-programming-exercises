package org.streams.models;

public class CourseSummary {
    private String nameCourse;
    private Integer sizeStudents;

    public CourseSummary() {
    }
    public CourseSummary(String nameCourse, Integer sizeStudents) {
        this.nameCourse = nameCourse;
        this.sizeStudents = sizeStudents;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public Integer getSizeStudents() {
        return sizeStudents;
    }

    public void setSizeStudents(Integer sizeStudents) {
        this.sizeStudents = sizeStudents;
    }

    @Override
    public String toString() {
        return "CourseSummary{" +
                "nameCourse='" + nameCourse + '\'' +
                ", sizeStudents=" + sizeStudents +
                '}';
    }
}
