package com.pichincha.model.requestapi;
import lombok.*;
//import lombok.NoArgsConstructor;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class RequestApi {
    private String message;
    private String to;
    private String from;
    private String timeToLifeSec;
}
