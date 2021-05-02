package com.umanizales.apipaseobarcos.controller;

import com.umanizales.apipaseobarcos.model.entities.BarcoEntity;
import com.umanizales.apipaseobarcos.service.BarcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/barcos")
@Validated
public class BarcoController {
    private BarcoService barcoService;
    @Autowired
    public BarcoController(BarcoService barcoService) {
        this.barcoService = barcoService;
    }
    @GetMapping
    public Iterable<BarcoEntity> getAllBarcos(){
        return barcoService.getAllBarcos();
    }
    @GetMapping(path = "/{code}")
    public BarcoEntity getByIdBarco(@PathVariable("code") String code){
        return barcoService.getBarcosByCode(code);
    }
    @PostMapping
    public boolean saveBarco(@RequestBody BarcoEntity barcoEntity){
        return barcoService.saveBarco(barcoEntity);
    }
    @PutMapping
    public BarcoEntity updateBarco(@RequestBody BarcoEntity barcoEntity){
        return barcoService.updateBarco(barcoEntity);
    }
    @DeleteMapping(path = "/{code}")
    public boolean deeteBarco(@PathVariable("code") String code){
        return barcoService.deleteBarco(code);
    }
}
