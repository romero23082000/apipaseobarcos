package com.umanizales.apipaseobarcos.controller;

import com.umanizales.apipaseobarcos.model.entities.BarcoEntity;
import com.umanizales.apipaseobarcos.service.BarcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public @ResponseBody ResponseEntity<Object> getAllBarcos(){
        return barcoService.getAllBarcos();
    }
    @GetMapping(path = "cantidad_barcos")
    public @ResponseBody ResponseEntity<Object> cantBarcos(){
        return barcoService.cantBarcos();
    }
    @GetMapping(path = "/{code}")
    public @ResponseBody ResponseEntity<Object> getByIdBarco(@PathVariable("code") String code){
        return barcoService.getBarcosByCode(code);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<Object> saveBarco(@RequestBody BarcoEntity barcoEntity){
        return barcoService.saveBarco(barcoEntity);
    }
    @PutMapping
    public @ResponseBody ResponseEntity<Object> updateBarco(@RequestBody BarcoEntity barcoEntity){
        return barcoService.updateBarco(barcoEntity);
    }
    @DeleteMapping(path = "/{code}")
    public @ResponseBody ResponseEntity<Object> deeteBarco(@PathVariable("code") String code){
        return barcoService.deleteBarco(code);
    }
}
