package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Book;
import org.streams.models.Library;

import java.util.Arrays;
import java.util.List;

public class ToArray {
    /**
     * Ejercicio 1:
     * Crea un array con los títulos de todos los libros en la biblioteca y muéstralo.
     *
     * Ejercicio 2:
     * Crea un array con los nombres de todos los autores en la biblioteca y muéstralo.
     *
     * Ejercicio 3:
     * Crea un array con los precios de todos los libros en la biblioteca y muéstralo.
     *
     * Ejercicio 4:
     * Crea un array con los nombres de los autores de los libros de ciencia ficción en la biblioteca y muéstralo.
     *
     * Ejercicio 5:
     * Crea un array con los títulos de los libros que tienen un precio mayor a $20 en la biblioteca y muéstralo.
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
        String[] bookTitles = library.getBooks().stream()
                .map(Book::getTitle)
                .toArray(String[]::new);
        Arrays.stream(bookTitles).forEach(System.out::println);
    }

    private static void exercise2(Library library) {
        String[] bookTitles = library.getBooks().stream()
                .map(book -> book.getAuthor().getName())
                .toArray(String[]::new);
        Arrays.stream(bookTitles).forEach(System.out::println);
    }

    private static void exercise3(Library library) {
        Double[] bookTitles = library.getBooks().stream()
                .map(Book::getPrice)
                .toArray(Double[]::new);
        Arrays.stream(bookTitles).forEach(System.out::println);
    }

    private static void exercise4(Library library) {
        String[] bookTitles = library.getBooks().stream()
                .filter(book -> "Science Fiction".equals(book.getGenre().getName()))
                .map(book -> book.getAuthor().getName())
                .toArray(String[]::new);
        Arrays.stream(bookTitles).forEach(System.out::println);
    }

    private static void exercise5(Library library) {
        String[] bookTitles = library.getBooks().stream()
                .filter(book -> book.getPrice()>20)
                .map(Book::getTitle)
                .toArray(String[]::new);
        Arrays.stream(bookTitles).forEach(System.out::println);
    }


}
