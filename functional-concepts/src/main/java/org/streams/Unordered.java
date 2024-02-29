package org.streams;

import org.streams.factory.Factory;
import org.streams.models.*;

import java.util.Comparator;
import java.util.List;

public class Unordered {

    /**
     * Ejercicio 1:
     * Crea un flujo con los nombres de los autores y muestra los nombres sin un orden específico.
     *
     * Ejercicio 2:
     * Encuentra el libro más caro en la biblioteca y muestra su título y precio, sin un orden específico.
     *
     * Ejercicio 3:
     * Crea un flujo con los géneros de los libros y muestra los géneros sin un orden específico.
     *
     * Ejercicio 4:
     * Encuentra el autor más joven en la biblioteca y muestra su nombre y edad, sin un orden específico.
     *
     *
     * Estos ejercicios te permitirán practicar el uso del método unordered() en
     * combinación con otros métodos de streams en Java 11. ¡Espero que encuentres útiles
     */
    public static void main(String[] args) {
        Library library = Factory.buildLibraryAndBook();
        exercise1(library);
        exercise2(library);
        exercise3(library);
        exercise4(library);
    }

    private static void exercise1(Library librarys) {
        List<String> libraysList = librarys.getBooks().stream()
                .map(book -> book.getAuthor().getName())
                .unordered()
                .distinct()
                .toList();

        System.out.println(libraysList);
    }

    private static void exercise2(Library library) {
        library.getBooks().stream()
                .max(Comparator.comparingDouble(Book::getPrice))
                .ifPresent(book -> System.out.println("Libro más caro: " + book.getTitle() + ", Precio: " + book.getPrice()));
    }

    private static void exercise3(Library library) {
        List<String> libraysList = library.getBooks().stream()
                .map(book -> book.getGenre().getName())
                .unordered()
                .distinct()
                .toList();
        System.out.println(libraysList);
    }

    private static void exercise4(Library library) {
        library.getBooks().stream()
                .min(Comparator.comparingDouble(book-> book.getAuthor().getAge()))
                .ifPresent(book -> System.out.println("El autor mas joven : " + book.getAuthor().getName() + "," +
                        " la edad del autor: " + book.getAuthor().getAge()));
    }

}
