package com.pichincha.api;
import com.pichincha.model.requestapi.RequestApi;
import com.pichincha.model.responseapi.ResponseApi;
import com.pichincha.usecase.devopsservice.DevOpsServiceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    DevOpsServiceUseCase devOpsServiceUseCase;
    @PostMapping(path = "/DevOps")
    public Mono<ResponseApi> sendMessage(@RequestBody RequestApi requestApi) {
        return devOpsServiceUseCase.sendRequestApi(requestApi.getMessage(), requestApi.getTo(), requestApi.getFrom(), requestApi.getTimeToLifeSec());
    }
}
