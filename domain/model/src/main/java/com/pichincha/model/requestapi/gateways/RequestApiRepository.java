package com.pichincha.model.requestapi.gateways;

import com.pichincha.model.requestapi.RequestApi;
import reactor.core.publisher.Mono;
public interface RequestApiRepository {
    public Mono<RequestApi> sendRequestApi(String message, String to, String from, String timeToLifeSec);
}
