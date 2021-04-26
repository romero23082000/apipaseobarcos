package com.umanizales.apipaseobarcos.model;

import lombok.*;
import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor



public class Empleado implements Serializable {
    private  String nombre;
    private  String identificacion;
    private  double salario;
}
