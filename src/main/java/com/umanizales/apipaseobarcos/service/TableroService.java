package com.umanizales.apipaseobarcos.service;

//comportamientos


import com.umanizales.apipaseobarcos.model.Dto.RespuestaDTO;
import com.umanizales.apipaseobarcos.model.entities.BarcoEntity;
import com.umanizales.apipaseobarcos.utiles.Contexto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service //aplicacion 1 mismo tablero pa los mismos usuarios
public class TableroService {
    private BarcoEntity[][] tableroBarco;
    private int ContadorAsiertos=0;
    private int ContadorErrores=0;

    public ResponseEntity<Object> inicializarTablero(int filas, int colum ) {
        if (filas <= 0 || colum <=0){
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.MESSAGE_ROWS_COLS_POSITIVE, null,
                            Contexto.ERROR_ROWS_COLS_POSITIVE)
                    , HttpStatus.CONFLICT);
        }

        tableroBarco = new BarcoEntity[filas][colum];
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.SUCCESSFUL,null,null),HttpStatus.CREATED);

    }
}
