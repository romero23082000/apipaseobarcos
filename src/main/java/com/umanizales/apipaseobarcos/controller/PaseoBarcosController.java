package com.umanizales.apipaseobarcos.controller;

import com.umanizales.apipaseobarcos.model.entities.BarcoEntity;
import com.umanizales.apipaseobarcos.service.ListaSEService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path =  "/paseobarcos")
@Validated
public class PaseoBarcosController {
    private ListaSEService listaSEService;

    public PaseoBarcosController(ListaSEService listaSEService) {
        this.listaSEService = listaSEService;
    }
    @GetMapping
    public String initBarcosListaSe(){
        listaSEService.load();
        return listaSEService.listarNodos();
    }
    @GetMapping(path = "/listar")
    public List<BarcoEntity> listarBarcosListaSe(){
        return  null;
}

    /*@GetMapping
        public  String getMessage(){
            return "Hola rome";
        }
        @GetMapping(path= "/message2")
        public  String Message2(){
            return "Soy un segundo mensaje";
        }
        @GetMapping(path= "/message3/{saludo}")
        public  String Message3(@PathVariable("saludo")String saludo){
            return "hola " + saludo;
        }*/
}
