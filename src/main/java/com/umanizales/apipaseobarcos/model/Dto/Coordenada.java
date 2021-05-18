package com.umanizales.apipaseobarcos.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Coordenada implements Serializable {
    private int fila;
    private int colum;


}
