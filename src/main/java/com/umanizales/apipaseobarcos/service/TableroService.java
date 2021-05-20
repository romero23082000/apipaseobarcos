package com.umanizales.apipaseobarcos.service;

//comportamientos


import com.umanizales.apipaseobarcos.model.Dto.CasillaBarco;
import com.umanizales.apipaseobarcos.model.Dto.Coordenada;
import com.umanizales.apipaseobarcos.model.Dto.RespuestaDTO;
import com.umanizales.apipaseobarcos.model.entities.BarcoEntity;
import com.umanizales.apipaseobarcos.repositorio.BarcoRepositorio;
import com.umanizales.apipaseobarcos.utiles.Contexto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service //aplicacion 1 mismo tablero pa los mismos usuarios
public class TableroService {
    private CasillaBarco[][] tableroBarco;
    private int contadorAsiertos = 0;
    private int contadorErrores = 0;
    private int contEscondidos = 0;
    private boolean estadoJuego = false;
    private ListaSEService listaSEService;
    private BarcoService barcoService;


    @Autowired
    public TableroService(ListaSEService listaSEService) {
        this.listaSEService = listaSEService;
    }
    public TableroService(BarcoService barcoService) {
        this.barcoService = barcoService;
    }


    public ResponseEntity<Object> inicializarTablero(int filas, int colum) {
        if (filas < 0 || colum < 0) {
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.MESSAGE_ROWS_COLS_POSITIVE, null,
                            Contexto.ERROR_ROWS_COLS_POSITIVE)
                    , HttpStatus.CONFLICT);
        }

        tableroBarco = new CasillaBarco[filas][colum];
        return new ResponseEntity<>(
                new RespuestaDTO(Contexto.SUCCESSFUL, null, null), HttpStatus.CREATED);

    }

    public ResponseEntity<Object> esconderBarco(String codigo, Coordenada coordenada) {
        if (coordenada.getFila() < 0 || coordenada.getColum() < 0) {
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.MESSAGE_ROWS_COLS_POSITIVE, null,
                            Contexto.ERROR_ROWS_COLS_POSITIVE)
                    , HttpStatus.CONFLICT);
        }
        BarcoEntity barcoEsconder = listaSEService.encontrarBarcoPorCodigo(codigo);
        if (barcoEsconder.getCasillas() < 0) {
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.MESSAGE_BOXES_NEGATIVE, null,
                            Contexto.ERROR_BOXES_NEGATIVE), HttpStatus.CONFLICT
            );
        }

        if (barcoEsconder != null) {
            //Validar cordenada y espacio libre
            if (validarCordenada(coordenada)) {
                //validar que no este ocupada
                if (tableroBarco[coordenada.getFila()][coordenada.getColum()] == null) {

                    tableroBarco[coordenada.getFila()][coordenada.getColum()] =
                            new CasillaBarco(barcoEsconder, false);
                    contEscondidos++;
                    if (contEscondidos == listaSEService.contarNodos()) {
                        estadoJuego = true;
                    }
                    return new ResponseEntity<>(
                            new RespuestaDTO(Contexto.SUCCESSFUL, null, null), HttpStatus.ACCEPTED);
                } else {
                    return new ResponseEntity<>(
                            new RespuestaDTO(Contexto.MESSAGE_BOX_OCUPATED, null,
                                    Contexto.ERROR_BOX_OCUPATED)
                            , HttpStatus.CONFLICT);
                }
            } else {
                return new ResponseEntity<>(
                        new RespuestaDTO(Contexto.MESSAGE_COORD_NOT_VALIDATE, null,
                                Contexto.ERROR_COORD_NOT_VALIDATE)
                        , HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(new RespuestaDTO(Contexto.DATA_NOT_FOUND, null,
                    Contexto.ERROR_DATA_NOT_FOUND), HttpStatus.NOT_FOUND);
        }

    }

    private boolean validarCordenada(Coordenada coordenada) {
        if (coordenada.getFila() < tableroBarco.length && coordenada.getColum() < tableroBarco[0].length) {
            return true;
        }
        return false;
    }

    public ResponseEntity<Object> visualizarTabler() {
        if (tableroBarco == null) {
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.MESSAGE_BOARD_VOID, null,
                            Contexto.ERROR_BOARD_VOID)
                    , HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.SUCCESSFUL, tableroBarco, null), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> SelecTablero() {
        if (barcoService.cantBarcos() <= 9) {
            tableroBarco = new CasillaBarco[10][10];
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.SUCCESSFUL, null, null), HttpStatus.CREATED);
        }
        if (barcoRepositorio.count() >= 10 && barcoRepositorio.count() <= 20) {
            tableroBarco = new CasillaBarco[20][20];
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.SUCCESSFUL, null, null), HttpStatus.CREATED);
        }
        if (barcoRepositorio.count() > 20) {
            tableroBarco = new CasillaBarco[30][30];
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.SUCCESSFUL, null, null), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.MESSAGE_BOARD_VOID, null,
                            Contexto.ERROR_BOARD_VOID)
                    , HttpStatus.CONFLICT);
        }

    }

    public ResponseEntity<Object> buscarBarco(Coordenada coordenada) {
        if (estadoJuego) {
            if (validarCordenada(coordenada)) {
                if (tableroBarco[coordenada.getColum()][coordenada.getFila()] != null &&
                        !tableroBarco[coordenada.getColum()][coordenada.getFila()].isMarcada()) {

                    tableroBarco[coordenada.getColum()][coordenada.getFila()].setMarcada(true);
                    contadorAsiertos++;
                    return this.validarEstadoJuego(true, tableroBarco[coordenada.getColum()][coordenada.getFila()]
                            .getBarcoEntity());

                } else {
                    contadorErrores++;
                    return this.validarEstadoJuego(false, null);
                }

            } else {
                return new ResponseEntity<>(
                        new RespuestaDTO(Contexto.MESSAGE_COORD_NOT_VALIDATE, null,
                                Contexto.ERROR_COORD_NOT_VALIDATE)
                        , HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(
                    new RespuestaDTO(Contexto.MESSAGE_STATE_GAME_INACTIVE, null,
                            Contexto.ERROR_STATE_GAME_INACTIVE)
                    , HttpStatus.CONFLICT);
        }

    }

    private ResponseEntity<Object> validarEstadoJuego(boolean exito, BarcoEntity barcoEntity) {
        if (exito) {
            if (contadorAsiertos == listaSEService.contarNodos()) {
                estadoJuego = false;
                tableroBarco = null;
                return new ResponseEntity<>(
                        new RespuestaDTO(Contexto.MESSAGE_WIN_THE_GAME,
                                null, null)
                        , HttpStatus.OK);
            } else {
                return new ResponseEntity<>(
                        new RespuestaDTO(Contexto.SUCCESSFUL, barcoEntity, null)
                        , HttpStatus.OK);
            }
        } else {
            if (contadorErrores >= this.listaSEService.contarNodos() * Contexto.PERCENTAGE_ERROR_GAME) {
                estadoJuego = false;
                tableroBarco = null;
                return new ResponseEntity<>(
                        new RespuestaDTO(Contexto.MESSAGE_LOST_THE_GAME, null,
                                Contexto.ERROR_LOST_THE_GAME)
                        , HttpStatus.CONFLICT);
            } else {

                return new ResponseEntity<>(
                        new RespuestaDTO(Contexto.MESSAGE_SHOT_FAILED, null,
                                null)
                        , HttpStatus.CONFLICT);
            }
        }
    }
}
