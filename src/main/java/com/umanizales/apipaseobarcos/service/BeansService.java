package com.umanizales.apipaseobarcos.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@RequestScope
//@SessionScope//para trabajar con el bean de secion
public class BeansService {
    private  int contador = 0;

    public  int aumentarContador(){
        return  ++contador;
    }
}
