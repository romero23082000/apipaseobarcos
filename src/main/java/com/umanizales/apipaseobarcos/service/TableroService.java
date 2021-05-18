package com.umanizales.apipaseobarcos.service;

//comportamientos


import com.umanizales.apipaseobarcos.model.Dto.Coordenada;
import com.umanizales.apipaseobarcos.model.Dto.RespuestaDTO;
import com.umanizales.apipaseobarcos.model.entities.BarcoEntity;
import com.umanizales.apipaseobarcos.utiles.Contexto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service //aplicacion 1 mismo tablero pa los mismos usuarios
public class TableroService {
    private BarcoEntity[][] tableroBarco;
    private int ContadorAsiertos=0;
    private int ContadorErrores=0;
    private ListaSEService listaSEService;

    @Autowired
    public TableroService(ListaSEService listaSEService) {
        this.listaSEService = listaSEService;
    }

    public ResponseEntity<Object> inicializarTablero(int filas, int colum ) {
        if (filas < 0 || colum <0){
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.MESSAGE_ROWS_COLS_POSITIVE, null,
                            Contexto.ERROR_ROWS_COLS_POSITIVE)
                    , HttpStatus.CONFLICT);
        }

        tableroBarco = new BarcoEntity[filas][colum];
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.SUCCESSFUL,null,null),HttpStatus.CREATED);

    }

    public ResponseEntity<Object> esconderBarco(String codigo, Coordenada coordenada){
        if (coordenada.getFila()<0 || coordenada.getColum()<0){
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.MESSAGE_ROWS_COLS_POSITIVE, null,
                            Contexto.ERROR_ROWS_COLS_POSITIVE)
                    , HttpStatus.CONFLICT);
        }
        BarcoEntity barcoEsconder = listaSEService.encontrarBarcoPorCodigo(codigo);
        if (barcoEsconder!=null){
            //Validar cordenada y espacio libre
            if (validarCordenada(coordenada)){
                //validar que no este ocupada
                if (tableroBarco[coordenada.getFila()][coordenada.getColum()]==null){
                    tableroBarco[coordenada.getFila()][coordenada.getColum()]=barcoEsconder;
                    return new ResponseEntity<>(
                            new RespuestaDTO(Contexto.SUCCESSFUL,null,null),HttpStatus.ACCEPTED);
                }
                else
                {
                    return new ResponseEntity<>(
                            new RespuestaDTO(Contexto.MESSAGE_BOX_OCUPATED, null,
                                    Contexto.ERROR_BOX_OCUPATED)
                            , HttpStatus.CONFLICT);
                }
            }else{
                return new ResponseEntity<>(
                        new RespuestaDTO(Contexto.MESSAGE_COORD_NOT_VALIDATE, null,
                                Contexto.ERROR_COORD_NOT_VALIDATE)
                        , HttpStatus.CONFLICT);
            }
        }else{
            return new ResponseEntity<>(new RespuestaDTO(Contexto.DATA_NOT_FOUND,null,
                    Contexto.ERROR_DATA_NOT_FOUND),HttpStatus.NOT_FOUND);
        }

    }
    private boolean validarCordenada(Coordenada coordenada){
        if (coordenada.getFila() < tableroBarco.length && coordenada.getColum() < tableroBarco[0].length){
            return true;
        }
        return false;
    }

    public ResponseEntity<Object> visualizarTabler(){
        if (tableroBarco==null){
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.MESSAGE_BOARD_VOID, null,
                            Contexto.ERROR_BOARD_VOID)
                    , HttpStatus.CONFLICT);
        }else
        {
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.SUCCESSFUL,tableroBarco,null),HttpStatus.OK);
        }
    }




}
