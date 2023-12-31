package com.pichincha.usecase.devopsservice;

import com.pichincha.model.enums.TechnicalExceptionEnum;
import com.pichincha.model.exceptions.TechnicalException;
import com.pichincha.model.requestapi.gateways.RequestApiRepository;
import com.pichincha.model.responseapi.ResponseApi;
import com.pichincha.model.responseapi.gateways.ResponseApiRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DevOpsServiceUseCase {
    private final RequestApiRepository requestApiRepository;
    private final ResponseApiRepository responseApiRepository;

    public Mono<ResponseApi> sendRequestApi(String message, String to, String from, int timeToLifeSec) {

        return requestApiRepository.sendRequestApi(message, to, from, timeToLifeSec)
                .map(responseApi -> {
                    return responseApiRepository.responseApi("Hellow "+responseApi.getTo()+" your message will be send").
                            onErrorMap(TechnicalException.class, e -> (new TechnicalException(TechnicalExceptionEnum.ERROR)));
                }
        ).onErrorMap(TechnicalException.class, e -> (new TechnicalException(TechnicalExceptionEnum.ERROR))).block();
    }
}
