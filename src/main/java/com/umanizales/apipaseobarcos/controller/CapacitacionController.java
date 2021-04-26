package com.umanizales.apipaseobarcos.controller;

import lombok.*;
import com.umanizales.apipaseobarcos.model.Empleado;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/capacitacion")

public class CapacitacionController {
    @GetMapping
    public Empleado GetEmployee(){
        Empleado andres = new Empleado("andres Romero","1007234295",
                350000);
        return andres;
    }
    @GetMapping(path = "empleados")
    public Empleado[] getAllEmployees(){
        Empleado[] empleados = new Empleado[3];
        empleados[0] = new Empleado("andres Romero","1007234295",
                350000);
        empleados[1] = new Empleado("pepito florez","1007230800",
                1350000);
        empleados[2] = new Empleado("juana de arco","1007290989",
                490000);
        return empleados;
    }
    @PostMapping
    public  Empleado crearEmpleado(@RequestBody Empleado employee){
        employee.setSalario(employee.getSalario()*1.15);
        return employee;
    }
}
