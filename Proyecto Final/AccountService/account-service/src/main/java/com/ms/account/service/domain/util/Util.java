package com.ms.account.service.domain.util;


import com.ms.account.service.domain.enums.ValidationExceptionEnum;
import com.ms.account.service.server.models.ErrorDetail;
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
