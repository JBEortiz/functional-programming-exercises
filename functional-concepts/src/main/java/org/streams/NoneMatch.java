package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Book;
import org.streams.models.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NoneMatch {
    /**
     * Ejercicio 1:
     * Verifica si alguno de los libros en la biblioteca tiene un precio mayor a $50 utilizando noneMatch().
     *
     * Ejercicio 2:
     * Verifica si ninguno de los libros en la biblioteca pertenece al género "Histórico" utilizando noneMatch().
     *
     * Ejercicio 3:
     * Verifica si ningún autor de los libros de terror tiene menos de 40 años utilizando noneMatch().
     *
     * Ejercicio 4:
     * Conprueba si existe un autor llamado "George Orwell" utilizando noneMatch() y extrae una lista de todos los libros sin este autor.
     *
     * Ejercicio 5:
     * Verifica si ningún libro en la biblioteca tiene un título que contenga la palabra "Fantasy" utilizando noneMatch().
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
        boolean more50 = library.getBooks().stream()
                .noneMatch(book -> book.getPrice()>50);
        System.out.println(more50);
    }

    private static void exercise2(Library library) {
        boolean nonaHistorical = library.getBooks().stream()
                .noneMatch(book -> book.getGenre().getName().equalsIgnoreCase("Historical"));
        System.out.println(nonaHistorical);
    }
    private static void exercise3(Library library) {
        boolean noneAuthor = library.getBooks().stream()
                .noneMatch(book -> book.getAuthor().getAge()<40);
        System.out.println(noneAuthor);
    }
    private static void exercise4(Library library) {
        List<Book> books =  library.getBooks().stream()
                .noneMatch(book ->  book.getAuthor().getName().equals("George Orwell"))
                ?
                new ArrayList<>()
                : library.getBooks().stream()
                .filter(book -> !"George Orwell".equals(book.getAuthor().getName()))
                .toList();

        boolean noBooksByGeorgeOrwell = library.getBooks().stream()
                .noneMatch(book -> book.getAuthor().getName().equals("George Orwell"));

        if (noBooksByGeorgeOrwell) {
            System.out.println("No hay libros de George Orwell");
        } else {
            System.out.println("Hay libros de George Orwell");
        }
        System.out.println(books);

    }
    private static void exercise5(Library library) {
            boolean contaisnFantasy = library.getBooks().stream()
                    .noneMatch(book -> book.getTitle().contains("Fantasy"));
            System.out.println(contaisnFantasy);
    }

}
