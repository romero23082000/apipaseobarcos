package com.umanizales.apipaseobarcos.controller;

import com.umanizales.apipaseobarcos.model.Dto.Coordenada;
import com.umanizales.apipaseobarcos.model.Dto.RequestBarcoCoordenada;
import com.umanizales.apipaseobarcos.model.ListaSE;
import com.umanizales.apipaseobarcos.repositorio.BarcoRepositorio;
import com.umanizales.apipaseobarcos.service.BarcoService;
import com.umanizales.apipaseobarcos.service.ListaSEService;
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
    @PostMapping(path = "seleccionar_tablero")
    public  ResponseEntity<Object> seleccionarTablero(@RequestBody Coordenada coordenada){ return tableroService.SelecTablero(coordenada.getSeleccionTablero());}
    @PostMapping(path = "esconderBarco")
    public @ResponseBody ResponseEntity<Object> esconderBarco(@RequestBody RequestBarcoCoordenada requestBarcoCoordenada){
        return tableroService.esconderBarco(requestBarcoCoordenada.getCodigo(), requestBarcoCoordenada.getCoordenada());
    }
    @PostMapping(path = "buscarBarco")
    public @ResponseBody ResponseEntity<Object> buscarBarco(@RequestBody Coordenada coordenada){
        return tableroService.buscarBarco(coordenada);
    }

}
