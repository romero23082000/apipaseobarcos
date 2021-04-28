package com.umanizales.apipaseobarcos.service;

import com.umanizales.apipaseobarcos.model.entities.TipoUsuarioEntity;
import com.umanizales.apipaseobarcos.repositorio.TipoUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class TipoUsuarioService {
    private TipoUsuarioRepositorio tipoUsuarioRepositorio;

    @Autowired
    public TipoUsuarioService(TipoUsuarioRepositorio tipoUsuarioRepositorio) {
        this.tipoUsuarioRepositorio = tipoUsuarioRepositorio;
    }

    public Iterable<TipoUsuarioEntity> getAllTipoUsuarios()
    {
        return tipoUsuarioRepositorio.findAll();
    }

    public TipoUsuarioEntity createTipoUsuario(TipoUsuarioEntity tipoUsuarioEntity)
    {
        return tipoUsuarioRepositorio.save(tipoUsuarioEntity);
    }
}
