package com.umanizales.apipaseobarcos.repositorio;


import com.umanizales.apipaseobarcos.model.entities.BarcoEntity;
import org.springframework.data.repository.CrudRepository;

public interface BarcoRepositorio extends CrudRepository<BarcoEntity, String> {
}
