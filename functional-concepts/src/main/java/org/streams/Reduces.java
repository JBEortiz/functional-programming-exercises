package org.streams;

import org.streams.factory.Factory;
import org.streams.models.*;

import java.util.Comparator;
import java.util.List;

public class Reduces {
    /**
     * Ejercicio 1:
     * Calcula la suma de las edades de todos los autores en la biblioteca.
     *
     * Ejercicio 2:
     * Escriba un código que utilice el método
     * reduce()para encontrar el título del libro más corto de la biblioteca.
     *
     * Ejercicio 3:
     * Escribe un código que utilice el método reduce()
     * para encontrar la suma de los precios de todos los libros de la biblioteca.
     */

    public static void main(String[] args) {
        Library library = Factory.buildLibraryAndBook();
        exercise1(library);
        exercise2(library);
        exercise3(library);
    }
    private static void exercise1(Library library) {
        int sumaEdadesReduce = library.getBooks()
                .stream()
                .map(Book::getAuthor)
                .map(Author::getAge)
                .reduce(0, Integer::sum);

        System.out.println("La suma de las edades de todos los autores es: " + sumaEdadesReduce);
    }

    private static void exercise2(Library library) {
        Book shortTitle = library.getBooks().stream()
                .reduce((b1, b2) -> b1.getTitle().length() <= b2.getTitle().length() ? b1 : b2)
                .get();
        System.out.println(shortTitle);
    }
    private static void exercise3(Library library) {
        double sumPriceBook = library.getBooks().stream()
                        .mapToDouble(Book::getPrice)
                                .reduce(0,Double::sum);

        System.out.println("La suma de precios de todos los libros" +sumPriceBook);
    }

}
