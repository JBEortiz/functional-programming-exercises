package org.streams.models;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@Data
public class Library {
    private List<Book> books;
}
