package com.pichincha.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder(toBuilder = true)
public class ResponseDTO<T> {

    @Autowired
    private MetaDTO.Meta meta;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T errors;

    public static <T> ResponseDTO success(T data) {
        return ResponseDTO.builder()
                .meta(MetaDTO.build(data))
                .data(data)
                .build();
    }

    public static <T> ResponseDTO buildError(T errors) {
        return ResponseDTO.builder()
                .meta(MetaDTO.build(errors))
                .errors(errors)
                .build();
    }

}
