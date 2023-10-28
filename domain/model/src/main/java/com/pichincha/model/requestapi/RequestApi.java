package com.pichincha.model.requestapi;
import lombok.*;
//import lombok.NoArgsConstructor;


@Getter
@Setter
@RequiredArgsConstructor
@Builder(toBuilder = true)
public class RequestApi {
    private String message;
    private String to;
    private String from;
    private int timeToLifeSec;

    public RequestApi(String message, String to, String from, int timeToLifeSec) {
        this.message = message;
        this.to = to;
        this.from = from;
        this.timeToLifeSec = timeToLifeSec;
    }
}
