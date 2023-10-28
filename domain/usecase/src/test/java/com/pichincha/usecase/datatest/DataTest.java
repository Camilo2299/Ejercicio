package com.pichincha.usecase.datatest;

import com.pichincha.model.requestapi.RequestApi;
import com.pichincha.model.responseapi.ResponseApi;

public class DataTest {
    public static RequestApi getRequestApi() {
        return RequestApi.builder().message("This is a test")
                .from("Rita Asturia")
                .to("Juan Perez")
                .timeToLifeSec(45)
                .build();
    }
    public static ResponseApi getResponseApi() {
        return ResponseApi.builder().message("Hellow Juan Perez your message will be send").build();
    }
}
