package com.msf.customer.middleend.domain;

import lombok.Data;

@Data
public class Error {
    private String title;

    private String detail;

    private Integer status;

}
