package com.umanizales.apipaseobarcos.service;


import com.umanizales.apipaseobarcos.model.Dto.RespuestaDTO;
import com.umanizales.apipaseobarcos.model.entities.BarcoEntity;
import com.umanizales.apipaseobarcos.repositorio.BarcoRepositorio;
import com.umanizales.apipaseobarcos.utiles.Contexto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BarcoService {
    private BarcoRepositorio barcoRepositorio;


    @Autowired
    public BarcoService(BarcoRepositorio barcoRepositorio) {
        this.barcoRepositorio = barcoRepositorio;
    }
    public ResponseEntity<Object> getAllBarcos(){
        RespuestaDTO respuesta= new RespuestaDTO(Contexto.SUCCESSFUL,
                barcoRepositorio.findAll(),null);
    return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    public ResponseEntity<Object> cantBarcos(){
        RespuestaDTO respuesta= new RespuestaDTO(Contexto.SUCCESSFUL,
                barcoRepositorio.count(),null);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    public ResponseEntity<Object> getBarcosByCode(String code){

        if (barcoRepositorio.existsById(code))
        {
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.SUCCESSFUL,
                            barcoRepositorio.findById(code).get(),null),HttpStatus.OK);
        }
        return new ResponseEntity<>(
                new RespuestaDTO(Contexto.DATA_NOT_FOUND,null,Contexto.ERROR_DATA_NOT_FOUND),HttpStatus.NOT_FOUND
        );
    }
    public ResponseEntity<Object> saveBarco(BarcoEntity barcoEntity){
        try {
            BarcoEntity barcoAlmacenado=barcoRepositorio.save(barcoEntity);
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.SUCCESSFUL,barcoAlmacenado
                            ,null),HttpStatus.CREATED);

        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.ERROR_PERSISTENCE_SAVE,
                            null
                            ,ex.getMessage()),HttpStatus.CONFLICT);
        }
    }
    public ResponseEntity<Object> deleteBarco(String code){
        if(barcoRepositorio.existsById(code))
        {
            barcoRepositorio.deleteById(code);
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.SUCCESSFUL,code
                            ,null),HttpStatus.OK);
        }
        return new ResponseEntity<>(
                new RespuestaDTO(Contexto.DATA_NOT_FOUND,
                        null
                        ,Contexto.ERROR_DATA_NOT_FOUND),HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<Object> updateBarco(BarcoEntity barcoEntity){
        if(barcoRepositorio.existsById(barcoEntity.getCodigo()))
        {
            try {
                BarcoEntity barcoAlmacenado=barcoRepositorio.save(barcoEntity);
                return new ResponseEntity<>(
                        new RespuestaDTO(Contexto.SUCCESSFUL,barcoAlmacenado
                                ,null),HttpStatus.ACCEPTED);
            }
            catch (Exception ex)
            {
                return new ResponseEntity<>(
                        new RespuestaDTO(Contexto.ERROR_PERSISTENCE_SAVE,
                                null
                                ,ex.getMessage()),HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity<>(
                new RespuestaDTO(Contexto.DATA_NOT_FOUND,
                        null
                        ,Contexto.ERROR_DATA_NOT_FOUND),HttpStatus.NOT_FOUND);

    }

}
