package com.pichincha.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@Getter
public enum TechnicalExceptionEnum {
    OK("OK","CORRECTO"),
    ERROR("ERROR","ERROR EN LA EJECUCION");

    private String code;
    private String message;

}
