package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Book;
import org.streams.models.Course;
import org.streams.models.Library;
import org.streams.models.Student;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FlatMapToIntToDoubleToLong {
    /**
     * Ejercicio 1:
     * Obtén un IntStream que represente las
     * edades de todos los autores en la biblioteca y muestra la suma de esas edades.
     * 
     * Ejercicio 2:
     * Obtén un DoubleStream que represente los precios de todos los libros de fantasía en la biblioteca y muestra el promedio de esos precios.
     *
     * Ejercicio 3:
     * Obtén un LongStream que represente el número de palabras en los títulos de todos los libros de ciencia ficción en la biblioteca y muestra la suma de esas palabras.
     * 
     * Ejercicio 4:
     * Obtén un DoubleStream que represente los precios de todos los libros de misterio en la biblioteca y muestra la edad promedio de esos libros.
     *
     * Ejercicio 5:
     * Obtén un DoubleStream que represente los precios de todos los libros escritos por autores mayores de 60 años en la biblioteca y muestra la suma de esos precios.
     * 
     * Ejercicio 6:
     * Obtén un LongStream que represente el número total de caracteres en los nombres de todos los autores en la biblioteca y muestra el promedio de esos caracteres.
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
        int sumaEdades = library.getBooks()
                .stream()
                .mapToInt(book -> book.getAuthor().getAge())
                .sum();
        System.out.println(sumaEdades);
    }

    private static void exercise2(Library library) {
        OptionalDouble promedioPreciosFantasia = library.getBooks()
                .stream()
                .filter(book -> book.getGenre().getName().equals("Fantasy"))
                .flatMapToDouble(book -> DoubleStream.of(book.getPrice()))
                .average();
        System.out.println(promedioPreciosFantasia.getAsDouble());
    }
    private static void exercise3(Library library) {
        long lengTitle = library.getBooks().stream()
                .filter(book -> book.getGenre().getName().equals("Science Fiction"))
                .flatMapToLong(book -> LongStream.of(book.getTitle().length()))
                .sum();
        System.out.println(lengTitle);
    }

    private static void exercise4(Library library) {
        DoubleStream prices = library.getBooks().stream()
                .filter(book -> book.getGenre().getName().equals("Science Fiction"))
                .flatMapToDouble(book -> DoubleStream.of(book.getPrice()));
        prices.forEach(System.out::println);

    }

    private static void exercise5(Library library) {
        DoubleStream bookWriting = library.getBooks().stream()
                .filter(book -> book.getAuthor().getAge()>60)
                .flatMapToDouble(book -> DoubleStream.of(book.getPrice()));
        bookWriting.forEach(System.out::println);

    }

    private static void exercise6(Library library) {
        OptionalDouble bookWriting = library.getBooks().stream()
                .filter(book -> book.getAuthor().getAge() > 60)
                .flatMapToLong(book -> LongStream.of(book.getAuthor().getName().length()))
                .average();
        System.out.println(bookWriting.getAsDouble());

    }
}
