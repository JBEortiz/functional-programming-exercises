package org.streams.models;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@Data
public class Author {
    private String name;
    private int age;
}
