package com.umanizales.apipaseobarcos.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class RequestBarcoCoordenada implements Serializable {
    private String codigo;
    private Coordenada coordenada;
}
