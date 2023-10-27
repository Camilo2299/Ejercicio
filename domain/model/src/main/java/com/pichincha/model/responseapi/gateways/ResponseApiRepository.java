package com.pichincha.model.responseapi.gateways;


import com.pichincha.model.responseapi.ResponseApi;
import reactor.core.publisher.Mono;

public interface ResponseApiRepository {
    public Mono<ResponseApi> responseApi(String message);

}
