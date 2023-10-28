package com.pichincha.model.exceptions;

import com.pichincha.model.enums.TechnicalExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TechnicalException extends RuntimeException{
    private final TechnicalExceptionEnum technicalExceptionEnum;

    public TechnicalException(Throwable cause, TechnicalExceptionEnum technicalException) {
        super(cause);
        this.technicalExceptionEnum = technicalException;
    }
}
