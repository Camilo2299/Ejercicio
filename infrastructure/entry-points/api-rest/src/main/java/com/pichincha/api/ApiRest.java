package com.pichincha.api;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pichincha.api.dto.ResponseDTO;
import com.pichincha.model.enums.TechnicalExceptionEnum;
import com.pichincha.model.requestapi.RequestApi;
import com.pichincha.usecase.devopsservice.DevOpsServiceUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.wildfly.common.annotation.NotNull;
import reactor.core.publisher.Mono;

@Log4j2
@Validated
@RestController
@RequestMapping(value = "/DevOps", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    DevOpsServiceUseCase devOpsServiceUseCase;
    @PostMapping()
    public Mono<ResponseEntity<ResponseDTO>> sendMessage(@RequestBody(required = false) @NotNull  RequestApi requestApi){
        ObjectNode object = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode jsonNodes = new ArrayNode(JsonNodeFactory.instance);
        return devOpsServiceUseCase.sendRequestApi(requestApi.getMessage(), requestApi.getTo(), requestApi.getFrom(), requestApi.getTimeToLifeSec()).map(responseApi -> {
            log.info(responseApi);
            return ResponseEntity.ok().body(ResponseDTO.success(responseApi));
        }).switchIfEmpty(Mono.defer(() -> {
            object.put("message", TechnicalExceptionEnum.ERROR.getMessage());
            jsonNodes.add(object);
            return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO.buildError(jsonNodes)));
        }));
    }
    @GetMapping()
    public Mono<ResponseEntity<ResponseDTO>> validateGet(){
        ObjectNode object = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode jsonNodes = new ArrayNode(JsonNodeFactory.instance);
        return Mono.just(ResponseEntity.ok().body(ResponseDTO.success(TechnicalExceptionEnum.ERROR.getMessage())));
    }
    @PutMapping()
    public Mono<ResponseEntity<ResponseDTO>> validatePut(){
        ObjectNode object = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode jsonNodes = new ArrayNode(JsonNodeFactory.instance);
        return Mono.just(ResponseEntity.ok().body(ResponseDTO.success(TechnicalExceptionEnum.ERROR.getMessage())));
    }
    @DeleteMapping()
    public Mono<ResponseEntity<ResponseDTO>> validateDelete(){
        ObjectNode object = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode jsonNodes = new ArrayNode(JsonNodeFactory.instance);
        return Mono.just(ResponseEntity.ok().body(ResponseDTO.success(TechnicalExceptionEnum.ERROR.getMessage())));
    }
}
