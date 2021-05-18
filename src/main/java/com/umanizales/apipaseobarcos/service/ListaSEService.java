package com.umanizales.apipaseobarcos.service;


import com.umanizales.apipaseobarcos.model.Empleado;
import com.umanizales.apipaseobarcos.model.ListaSE;
import com.umanizales.apipaseobarcos.model.entities.BarcoEntity;
import com.umanizales.apipaseobarcos.repositorio.BarcoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;

@Service// Se comporta como un bean de aplicacion
public class ListaSEService {
    private ListaSE listaSE;

    private BarcoRepositorio barcoRepositorio;

    @Autowired
    public ListaSEService(BarcoRepositorio barcoRepositorio) {
        this.barcoRepositorio = barcoRepositorio;
        this.listaSE = new ListaSE();
    }

    @PostConstruct
    public   void load(){
        Iterable<BarcoEntity> barcos = barcoRepositorio.findAll();
        for(BarcoEntity barquitos:barcos){
            this.listaSE.adicionarAlFinal(barquitos);
        }
        System.out.println("listaSE.getCont() = " + listaSE.getCont());
    }
    public int contarNodos(){
        return listaSE.getCont();
    }

    public String listarNodos(){
    return listaSE.listadoNodos();
    }

    public boolean adicionarNodo(Object dato)
    {
        this.listaSE.adicionarAlFinal(dato);
        if(dato instanceof BarcoEntity) {
            this.barcoRepositorio.save((BarcoEntity) dato);
        }
        return true;
    }

    public BarcoEntity encontrarBarcoPorCodigo(String codigo){
       return (BarcoEntity) this.listaSE.EncontrarDatoPorCodigo(codigo);
    }
}

