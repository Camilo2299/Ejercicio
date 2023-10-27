package com.pichincha.model.responseapi;
import lombok.*;
//import lombok.NoArgsConstructor;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class ResponseApi {
    private String message;

}
