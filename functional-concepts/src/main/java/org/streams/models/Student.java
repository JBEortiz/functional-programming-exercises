package org.streams.models;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@Data
public class Student {
    private String name;
    private int age;
    private String email;
    private AdditionalInfo additionalInfo;


}
