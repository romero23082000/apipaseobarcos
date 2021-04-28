package com.umanizales.apipaseobarcos.controller;

import com.umanizales.apipaseobarcos.model.entities.TipoUsuarioEntity;
import com.umanizales.apipaseobarcos.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tipousuario")
@Validated
public class TipoUsuarioController {

    private TipoUsuarioService tipoUsuarioService;

    @Autowired
    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @GetMapping
    public Iterable<TipoUsuarioEntity> getAllTipoUsuarios(){
    return tipoUsuarioService.getAllTipoUsuarios();
    }
    @PostMapping
    public TipoUsuarioEntity createTipoUsuarioEntity(@RequestBody TipoUsuarioEntity tipoUsuarioEntity){
        return tipoUsuarioService.createTipoUsuario(tipoUsuarioEntity);
    }
}
