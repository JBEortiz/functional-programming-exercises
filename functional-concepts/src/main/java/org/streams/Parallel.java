package org.streams;

import org.streams.factory.Factory;
import org.streams.models.Book;
import org.streams.models.Library;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Parallel {
    /**
     * Ejercicio 1:
     * Calcula la edad promedio de los autores de todos los libros en la biblioteca de manera paralela.
     *
     * Ejercicio 2:
     * Crea un IntStream paralelo con las edades de los autores de los libros de misterio en la biblioteca y muéstralo.
     *
     * Ejercicio 3:
     * Calcula la diferencia de edades entre el autor más joven y el autor más viejo de la biblioteca de manera paralela.
     *
     * Ejercicio 4:
     * Calcula la suma de las edades de los autores de los libros que tienen un precio mayor a $20 en la biblioteca de manera paralela.
     *
     * Ejercicio 5:
     * Calcula la edad promedio de los autores de los libros escritos por autores mayores de 70 años en la biblioteca de manera paralela.
     *
     * Ejercicio 6:
     * Calcula la suma de las edades de los autores de los libros de terror o misterio en la biblioteca de manera paralela.
     *
     * Ejercicio 7:
     * Calcula la diferencia de edades entre el autor más joven y el autor más viejo de los libros de fantasía o ciencia ficción en la biblioteca de manera paralela.
     */

    public static void main(String[] args) {
        Library library = Factory.buildLibraryAndBook();
        exercise1(library);
        exercise2(library);
        exercise3(library);
        exercise4(library);
        exercise5(library);
        exercise6(library);
        exercise7(library);
        exercise8(library);

    }

    private static void exercise1(Library library) {
        double averageAge = library.getBooks().parallelStream()
                .mapToDouble(book -> book.getAuthor().getAge())
                .average()
                .orElse(0.0);
    }

    private static void exercise2(Library library) {
        IntStream ageStream = library.getBooks().parallelStream()
                .filter(book -> book.getGenre().getName().equals("Mystery"))
                .mapToInt(book -> book.getAuthor().getAge());
        System.out.println("Edades de los autores de los libros de misterio (IntStream paralelo):");
        ageStream.forEach(System.out::println);
    }
    private static void exercise3(Library library) {
        List<Integer> bookTitles = library.getBooks().parallelStream()
                .filter(book -> "Mystery".equals(book.getGenre().getName()))
                .map(book -> book.getAuthor().getAge())
                .toList();
        bookTitles.forEach(System.out::println);
    }
    private static void exercise4(Library library) {
        int ageDifference = library.getBooks().parallelStream()
                .mapToInt(book -> book.getAuthor().getAge())
                .reduce((min, max) -> Math.max(min, max) - Math.min(min, max))
                .orElse(0);

        System.out.println("Diferencia de edades entre el autor más joven y el autor más viejo: " + ageDifference);

    }

    private static void exercise5(Library library) {
        int sumAge = library.getBooks().parallelStream()
                .filter(book -> book.getAuthor().getAge()>20)
                .mapToInt(book -> book.getAuthor().getAge())
                .sum();
        System.out.println(sumAge);

    }

    private static void exercise6(Library library) {
        double averageAge = library.getBooks().parallelStream()
                .filter(book -> book.getAuthor().getAge()>70)
                .mapToInt(book -> book.getAuthor().getAge())
                .average()
                .getAsDouble();
        System.out.println(averageAge);
    }

    private static void exercise7(Library library) {
        double averageAge = library.getBooks().parallelStream()
                .filter(book -> "Mystery".equals(book.getGenre().getName()) || "Horror".equals(book.getGenre().getName()))
                .mapToInt(book -> book.getAuthor().getAge())
                .average()
                .getAsDouble();
        System.out.println(averageAge);
    }
    private static void exercise8(Library library) {
        List<Integer> averageAge = library.getBooks().parallelStream()
                .filter(book -> "Science Fiction".equals(book.getGenre().getName()) && "Fantasy".equals(book.getGenre().getName()))
                .map(book -> book.getAuthor().getAge())
                .toList();

        if (!averageAge.isEmpty()) {
            int minAge = averageAge.stream().min(Integer::compareTo).get();
            int maxAge =  averageAge.stream().max(Integer::compareTo).get();
            System.out.println(maxAge - minAge);
        }
    }


}
