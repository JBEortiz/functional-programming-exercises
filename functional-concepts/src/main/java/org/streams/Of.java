package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Book;
import org.streams.models.Library;

import java.util.List;
import java.util.stream.Stream;

public class Of {
    /**
     * Ejercicio 1 (fácil)
     * Escribe un código que utiliza el método
     * of()para crear un flujo de todos los libros de la biblioteca.
     *
     * Ejercicio 2 (medio)
     * Escribe un código que utiliza el método of()
     * para crear un flujo de todos los libros escritos por Stephen King.
     *
     * Ejercicio 3 (difícil)
     * Escribe un código que utiliza el método of()
     * para crear un flujo de todos los libros escritos por autores de más de 80 años.
     */

    public static void main(String[] args) {
        Library library = Factory.buildLibraryAndBook();
        exercise1(library);
        exercise2(library);
        exercise3(library);
    }

    private static void exercise1(Library library) {
        List<Book> books = library.getBooks();
        Stream<List<Book>> bookStream = Stream.of(library.getBooks());
        bookStream.forEach(System.out::println);
    }

    private static void exercise2(Library library) {
        Stream<Book> kingBooks =  library.getBooks().stream()
                .filter(book -> book.getAuthor().getName().equals("Stephen King"));
        kingBooks.forEach(System.out::println);

    }
    private static void exercise3(Library library) {
        Stream<Book> oldAuthorsBooks = library.getBooks().stream()
                .filter(book -> book.getAuthor().getAge() > 80);
        oldAuthorsBooks.forEach(System.out::println);

    }
}
