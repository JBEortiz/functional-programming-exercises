package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Book;
import org.streams.models.Course;
import org.streams.models.CourseSummary;
import org.streams.models.Library;

import java.util.List;

public class Sorted {
    /**
     *Ejercicio 1:
     * Ordena los libros por el nombre del autor de forma ascendente.
     *
     * Ejercicio 2:
     * Ordena los libros por el precio de forma descendente.
     *
     * Ejercicio 3:
     * Ordena los libros por el nombre del libro de forma ascendente, y si el nombre es el mismo, ordena por el nombre del autor de forma descendente.
     *
     * Ejercicio 4:
     * Ordena los autores por la edad de forma descendente.
     *
     * Ejercicio 5:
     * Ordena los libros por el nombre del género de forma ascendente, y si el nombre del género es el mismo, ordena por el precio de forma descendente.
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
        List<Book> libarys = library.getBooks().stream()
                .sorted((book1, book2) -> book1.getAuthor().getName().compareTo(book2.getAuthor().getName()))
                .toList();
        System.out.println(libarys);
    }

    private static void exercise2(Library library) {
        List<Book> libarys = library.getBooks().stream()
                .sorted((book1, book2) -> Double.compare(book2.getPrice(), book1.getPrice()))
                .toList();
        System.out.println(libarys);
    }

    private static void exercise3(Library library) {
        List<Book> sortedBooksByNameAndAuthor = library.getBooks().stream()
                .sorted((book1, book2) -> {
                    int result = book1.getTitle().compareTo(book2.getTitle());
                    return (result == 0) ? book2.getAuthor().getName().compareTo(book1.getAuthor().getName()) : result;
                })
                .toList();
        System.out.println(sortedBooksByNameAndAuthor);
    }

    private static void exercise4(Library library) {
        List<Book> sortedByAgeAuthor = library.getBooks().stream()
                .sorted((book1, book2) -> Double.compare(book1.getAuthor().getAge(),book2.getAuthor().getAge()))
                .toList();
        System.out.println(sortedByAgeAuthor);
    }

    private static void exercise5(Library library) {
        List<Book> sortedBooksByNameGenreAscOrPriceDesc= library.getBooks().stream()
                .sorted((book1, book2) -> {
                    int result = book1.getGenre().getName().compareTo(book2.getGenre().getName());
                    return (result == 0) ? Double.compare(book1.getPrice(),book2.getPrice()) : result;
                })
                .toList();
        System.out.println(sortedBooksByNameGenreAscOrPriceDesc);
    }

}
