package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Author;
import org.streams.models.Book;
import org.streams.models.Genre;
import org.streams.models.Library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinAnMax {
    /**
     * Ejercicio 1:
     * Encuentra el libro más caro en la biblioteca y muestra su título, precio y autor.
     *
     * Ejercicio 2:
     * Encuentra al autor más joven de la biblioteca y muestra su nombre y edad.
     *
     * Ejercicio 3:
     * Encuentra al autor más viejo de los libros de ciencia ficción y muestra su nombre y edad.
     *
     * Ejercicio 4:
     * Encuentra el libro más corto (en términos de número de caracteres en el título) y muestra su título y autor.
     *
     * Ejercicio 5:
     * Encuentra al autor más viejo de los libros de misterio y muestra su nombre y edad.
     *
     *
     * @param args
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
        Book mostExpensiveBook = library.getBooks().stream()
                .max(Comparator.comparing(Book::getPrice)).orElse(new Book());

        System.out.println("El libro más caro es " + mostExpensiveBook.getTitle() + " por " + mostExpensiveBook.getPrice() + "€");
    }

    private static void exercise2(Library library) {
        Book youngestAuthor = library.getBooks().stream()
                .min(Comparator.comparing(book-> book.getAuthor().getAge())).orElse(new Book("",new Author(),0,new Genre()));

        System.out.println("El autor más joven es "+ youngestAuthor.getAuthor());
    }
    private static void exercise3(Library library) {
        Author mostExpensiveBook = library.getBooks().stream()
                .filter(book -> book.getGenre().getName().equals("Ciencia Ficción"))
                .map(Book::getAuthor)
                .max(Comparator.comparing(Author::getAge))
                .orElse(new Author());

        System.out.println("El autor más viejo de los libros de ciencia ficción es " + mostExpensiveBook.getName() + " con " + mostExpensiveBook.getAge() + " años");
    }
    private static void exercise4(Library library) {
        Author author = library.getBooks().stream()
                .filter(book -> book.getGenre().getName().equals("Misterio"))
                .map(Book::getAuthor)
                .max(Comparator.comparing(Author::getAge))
                .orElse(new Author());

    }
    private static void exercise5(Library library) {
        Book shortestBook = library.getBooks().stream()
                .min(Comparator.comparing(Book::getTitle)
                        .thenComparing(book -> book.getAuthor().getName()))
                .orElse(new Book("", new Author(), 0, new Genre()));

        System.out.println("El libro más corto es " + shortestBook.getTitle() + " de " + shortestBook.getAuthor().getName());
    }
}
