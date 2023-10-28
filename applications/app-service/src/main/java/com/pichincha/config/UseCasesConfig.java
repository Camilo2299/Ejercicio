package com.pichincha.config;

import com.pichincha.model.requestapi.RequestApi;
import com.pichincha.model.requestapi.gateways.RequestApiRepository;
import com.pichincha.model.responseapi.ResponseApi;
import com.pichincha.model.responseapi.gateways.ResponseApiRepository;
import com.pichincha.usecase.devopsservice.DevOpsServiceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class UseCasesConfig {
    @Bean
    public DevOpsServiceUseCase devOpsServiceUseCase(RequestApiRepository requestApiRepository, ResponseApiRepository responseApiRepository) {
        return new DevOpsServiceUseCase(requestApiRepository,responseApiRepository);
    }
    @Bean
    public RequestApiRepository requestApiRepository() {
        return new RequestApiRepository() {
            @Override
            public Mono<RequestApi> sendRequestApi(String message, String to, String from, int timeToLifeSec) {
                return Mono.just(RequestApi.builder().message(message).to(to).from(from).timeToLifeSec(timeToLifeSec).build());
            }
        };
    }
    @Bean
    public ResponseApiRepository responseApiRepository() {
        return new ResponseApiRepository() {
            @Override
            public Mono<ResponseApi> responseApi(String message) {
                return Mono.just(ResponseApi.builder().message(message).build());
            }
        };
    }
}
