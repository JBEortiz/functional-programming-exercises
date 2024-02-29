package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Book;
import org.streams.models.Library;

import java.util.List;
import java.util.stream.Stream;

public class OnClose {
    /**
     * Ejercicio 1:
     *
     * Escriba un código que utilice el método onClose()para
     * registrar un evento que se produzca cuando se cierre el flujo.
     * El evento debe imprimir el título de todos los libros que hayan sido leídos.
     * Ejercicio 2:
     *
     * Escribe un código que utilice el método onClose()para
     * cerrar el flujo cuando se haya leído un libro determinado.
     *
     */
    public static void main(String[] args) {
        Library library = Factory.buildLibraryAndBook();
        exercise1(library);
        exercise2(library);
    }

    private static void exercise1(Library library) {
        library.getBooks().stream()
                .onClose(() -> {
                    library.getBooks().stream()
                            .forEach(book -> System.out.println(book.getTitle()));
                })
                .forEach(book -> System.out.println(book.getTitle()));
    }

    private static void exercise2(Library library) {
        library.getBooks().stream()
                .filter(book -> book.getTitle().equals("Guerra y Paz"))
                .onClose(() -> {
                    System.out.println("El flujo se ha cerrado.");
                })
                .forEach(book -> System.out.println(book.getAuthor()));

    }

}
