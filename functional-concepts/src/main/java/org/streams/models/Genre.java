package org.streams.models;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@Data
public class Genre {
    private String name;
    private String description;
}
