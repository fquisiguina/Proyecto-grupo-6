package com.ms.customer.service.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class ErrorControlado {

    private String codigo;

    private String descripcion;

}
