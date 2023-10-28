package com.pichincha.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class MetaDTO {

    private static String deploymentVersion = "0.0.1";

    @Data
    @Builder(toBuilder = true)
    public static class Meta {

        @JsonProperty("_version")
        private String version;

        @JsonProperty("_requestDate")
        private LocalDateTime requestDate;

        @JsonProperty("_responseSize")
        private int responseSize;

        @JsonProperty("_requestClient")
        private String requestClient;

    }

    public static <T> Meta build(T data) {
        return Meta.builder()
                .version(deploymentVersion)
                .requestDate(LocalDateTime.now())
                .responseSize(getDataSize(data))
              //  .requestClient(request.getRemoteAddress().getAddress().getHostAddress())
                .build();
    }

    private static <T> int getDataSize(T data) {
        if (data instanceof List) {
            return ((List) data).size();
        }
        return 1;
    }


}
