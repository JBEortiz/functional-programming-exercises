package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Book;
import org.streams.models.Course;
import org.streams.models.Library;
import org.streams.models.Student;

import java.util.List;

public class ForEach {

    /**
     * Ejercicio 1:
     * Imprime el título de todos los libros en la biblioteca.
     *
     * Ejercicio 2:
     * Imprime el nombre y la edad de todos los autores en la biblioteca.
     *
     * Ejercicio 3:
     * Calcula y muestra el precio total de todos los libros en la biblioteca.
     *
     * Ejercicio 4:
     * Imprime los nombres de los autores cuya edad sea superior a 60 años.
     *
     * Ejercicio 5:
     * Imprime el título y el género de los libros de terror (horror) en la biblioteca.
     *
     * Ejercicio 6:
     *  Imprime el todos los libros que sean de genero historico y que tengan un precio superior a 10.
     *
     */
    public static void main(String[] args) {
        Library library = Factory.buildLibraryAndBook();
        exercise1(library);
        exercise2(library);
        exercise3(library);
        exercise4(library);
        exercise5(library);
    }

    private static void exercise1(Library library) {
        library.getBooks().stream()
                .forEach(book -> System.out.println(book.getTitle()));
    }

    private static void exercise2(Library library) {
        library.getBooks().stream()
                .forEach(book -> System.out.println("Name: " + book.getAuthor().getName() + " Age: " + book.getAuthor().getAge()));
    }

    private static void exercise3(Library library) {
        double result = library.getBooks().stream()
                .mapToDouble(Book::getPrice)
                .sum();
        System.out.println(result);
    }

    private static void exercise4(Library library) {
        library.getBooks().stream()
                        .filter(author-> author.getAuthor().getAge()>60)
                                .forEach(author-> System.out.println(author.getAuthor().getAge()));
    }

    private static void exercise5(Library library) {
        library.getBooks().stream()
                .filter(book-> "Horror".equals(book.getGenre().getName()))
                .forEach(book-> System.out.println(book.getTitle()+" Genre: "+ book.getGenre().getName()));
    }
    private static void exercise6(Library library) {
      library.getBooks().stream()
              .filter(book -> "Historical".equals(book.getGenre().getName()))
              .filter(book -> book.getPrice()>10)
              .forEach(System.out::println);
    }
}
