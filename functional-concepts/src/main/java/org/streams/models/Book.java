package org.streams.models;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@Data
public class Book {

    private String title;
    private Author author;
    private double price;
    private  Genre genre;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                '}';
    }
}
