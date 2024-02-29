package org.streams.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Builder
@Data
public class AdditionalInfo {
    private String someInfo;

    public AdditionalInfo(String someInfo) {
        this.someInfo = someInfo;
    }

}
