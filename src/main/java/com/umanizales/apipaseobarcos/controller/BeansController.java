package com.umanizales.apipaseobarcos.controller;

import com.umanizales.apipaseobarcos.service.BeansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/beans")
@Validated
public class BeansController {

    private BeansService beansService;

    @Autowired
    public BeansController(BeansService beansService) {
        this.beansService = beansService;
    }

    @GetMapping
    public  int aumentarContador(){
        return beansService.aumentarContador();
    }
}
