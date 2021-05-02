package com.umanizales.apipaseobarcos.service;


import com.umanizales.apipaseobarcos.model.entities.BarcoEntity;
import com.umanizales.apipaseobarcos.repositorio.BarcoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarcoService {
    private BarcoRepositorio barcoRepositorio;

    @Autowired
    public BarcoService(BarcoRepositorio barcoRepositorio) {
        this.barcoRepositorio = barcoRepositorio;
    }
    public Iterable<BarcoEntity> getAllBarcos(){
    return barcoRepositorio.findAll();
    }
    public BarcoEntity getBarcosByCode(String code){
    return barcoRepositorio.findById(code).get();
    }
    public Boolean saveBarco(BarcoEntity barcoEntity){
        barcoRepositorio.save(barcoEntity);
        return true;
    }
    public Boolean deleteBarco(String code){
        barcoRepositorio.deleteById(code);
        return true;
    }
    public BarcoEntity updateBarco(BarcoEntity barcoEntity){
       return barcoRepositorio.save(barcoEntity);
    }


}
