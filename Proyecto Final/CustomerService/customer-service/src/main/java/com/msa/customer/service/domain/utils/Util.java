package com.msa.customer.service.domain.utils;

import com.ms.customer.service.server.models.ErrorDetail;
import com.msa.customer.service.domain.exceptions.ValidationExceptionEnum;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class Util {
    public static ErrorDetail generateErrorDetail(ObjectError error){
        ErrorDetail errorDetail = new ErrorDetail();
        String attributeName;

        if (error instanceof FieldError) {
            FieldError fieldError = (FieldError) error;
            attributeName = fieldError.getField();

            if(ValidationExceptionEnum.containsPattern(error.getDefaultMessage())){
                errorDetail.message(attributeName + ":" + ValidationExceptionEnum.fromPattern(error.getDefaultMessage())
                        .getDescription());
                return errorDetail;
            }else{
                errorDetail.message(attributeName + ":" + error.getDefaultMessage());
            }
        } else {
            attributeName = "unknown";
            errorDetail.message(attributeName+ ":" + error.getDefaultMessage());
        }

        return errorDetail;
    }
}
