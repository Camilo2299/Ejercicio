package com.pichincha.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BusinessExceptionEnum {
    VALIDACION("ERROR_VALIDACION", "ERROR VALIDACION"), EJECUCION("ERROR_EJECUCION", "ERROR EN EJECUCION");
    private String code;
    private String message;

}
