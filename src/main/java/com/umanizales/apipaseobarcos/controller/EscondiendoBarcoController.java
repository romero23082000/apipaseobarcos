package com.umanizales.apipaseobarcos.controller;

import com.umanizales.apipaseobarcos.model.Dto.Coordenada;
import com.umanizales.apipaseobarcos.model.Dto.RequestBarcoCoordenada;
import com.umanizales.apipaseobarcos.service.TableroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/escondetubarco")
@RestController
@Validated
public class EscondiendoBarcoController {
    private TableroService tableroService;

    @Autowired
    public EscondiendoBarcoController(TableroService tableroService) {
        this.tableroService = tableroService;
    }

    @PostMapping(path = "iniciar_tabler")
    public @ResponseBody ResponseEntity<Object> iniciarTablero(@RequestBody Coordenada coordenada){
        return tableroService.inicializarTablero(coordenada.getFila(), coordenada.getColum());
    }
    @GetMapping(path = "ver_tablero")
    public ResponseEntity<Object> visualizarTablero(){
        return tableroService.visualizarTabler();
    }
    @PostMapping(path = "esconderBarco")
    public @ResponseBody ResponseEntity<Object> esconderBarco(@RequestBody RequestBarcoCoordenada requestBarcoCoordenada){
        return tableroService.esconderBarco(requestBarcoCoordenada.getCodigo(), requestBarcoCoordenada.getCoordenada());
    }

}
