package org.streams.factory;

import org.streams.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factory {

    public static List<Course> buildCoursesAndStudents(){
        // Crear una lista de cursos con estudiantes
        List<Course> courses = new ArrayList<>();

        // Curso de Programación Java
        Course javaCourse = new Course("Java Programming");
        javaCourse.addStudent(new Student("John", 25, "john@example.com", new AdditionalInfo("Additional Data for John")));
        javaCourse.addStudent(new Student("Alice", 22, "alice@example.com", new AdditionalInfo("Additional Data for Alice")));
        javaCourse.addStudent(new Student("Bob", 28, "bob@example.com", new AdditionalInfo("Additional Data for Bob")));
        courses.add(javaCourse);

// Curso de Desarrollo Web
        Course webDevelopmentCourse = new Course("Web Development");
        webDevelopmentCourse.addStudent(new Student("Eva", 24, "eva@example.com", new AdditionalInfo("Additional Data for Eva")));
        webDevelopmentCourse.addStudent(new Student("Charlie", 26, "charlie@example.com", new AdditionalInfo("Additional Data for Charlie")));
        courses.add(webDevelopmentCourse);

// Curso de Machine Learning
        Course machineLearningCourse = new Course("Machine Learning");
        machineLearningCourse.addStudent(new Student("Grace", 30, "grace@example.com", new AdditionalInfo("Additional Data for Grace")));
        machineLearningCourse.addStudent(new Student("Daniel", 27, "daniel@example.com", new AdditionalInfo("Additional Data for Daniel")));
        courses.add(machineLearningCourse);

// Curso de Diseño de UI/UX
        Course uiUxCourse = new Course("UI/UX Design");
        uiUxCourse.addStudent(new Student("Sophia", 23, "sophia@example.com", new AdditionalInfo("Additional Data for Sophia")));
        uiUxCourse.addStudent(new Student("James", 29, "james@example.com", new AdditionalInfo("Additional Data for James")));
        courses.add(uiUxCourse);

// Curso de Ciberseguridad
        Course cybersecurityCourse = new Course("Cybersecurity");
        cybersecurityCourse.addStudent(new Student("Olivia", 26, "olivia@example.com", new AdditionalInfo("Additional Data for Olivia")));
        cybersecurityCourse.addStudent(new Student("William", 31, "william@example.com", new AdditionalInfo("Additional Data for William")));
        courses.add(cybersecurityCourse);

        return courses;
    }
    public static Library buildLibraryAndBook(){
        // Autores adicionales
        Author leoTolstoy = new Author("Leo Tolstoy", 82);
        Author agathaChristie = new Author("Agatha Christie", 85);
        Author stephenKing = new Author("Stephen King", 73);
        Author maryShelley = new Author("Mary Shelley", 53);
        Author hGWells = new Author("H.G. Wells", 79);
        Author jkRowling = new Author("J.K. Rowling", 55);
        Author jrrTolkien = new Author("J.R.R. Tolkien", 81);
        Author georgeOrwell = new Author("George Orwell", 46);

        // Géneros adicionales
        Genre mystery = new Genre("Mystery", "Fiction dealing with the solution of a crime or the uncovering of secrets");
        Genre horror = new Genre("Horror", "Fiction intended to scare, unsettle, or horrify the reader");
        Genre historical = new Genre("Historical", "Fiction set in the past, with attention to period detail");
        Genre scienceFiction = new Genre("Science Fiction", "Fiction with futuristic elements based on imagined future scientific discoveries");
        Genre fantasy = new Genre("Fantasy", "Fiction with magical or supernatural elements");
        Genre dystopian = new Genre("Dystopian", "An imagined society where there is great suffering or injustice");

        // Libros
        Book warAndPeace = new Book("War and Peace", leoTolstoy, 20.00, historical);
        Book murderOnTheOrientExpress = new Book("Murder on the Orient Express", agathaChristie, 15.99, mystery);
        Book theShining = new Book("The Shining", stephenKing, 25.99, horror);
        Book frankenstein = new Book("Frankenstein", maryShelley, 10.99, horror);
        Book theTimeMachine = new Book("The Time Machine", hGWells, 12.99, scienceFiction);
        Book harryPotter = new Book("Harry Potter", jkRowling, 39.99, fantasy);
        Book lordOfTheRings = new Book("The Lord of the Rings", jrrTolkien, 29.99, fantasy);
        Book nineteenEightyFour = new Book("1984", georgeOrwell, 19.99, dystopian);

        // Biblioteca
        return new Library(Arrays.asList(harryPotter, lordOfTheRings, nineteenEightyFour,warAndPeace,
                murderOnTheOrientExpress,
                theShining,
                frankenstein,
                theTimeMachine));
    }
}
