package com.umanizales.apipaseobarcos.utiles;

public final class Contexto
{
    public static final String DATA_NOT_FOUND="Dato no encontrado";
    public static final String ERROR_DATA_NOT_FOUND="El dato suministrado no generó resultados";
    public static final String SUCCESSFUL="Exitoso";
    public static final String MESSAGE_SUCCESSFUL="Operación efectuada con éxito";
    public static final String ERROR_PERSISTENCE_SAVE="Ha ocurrido un error al intentar guardar en base de datos";

    public static final float PERCENTAGE_ERROR_GAME= 0.3f;
    public static final String MESSAGE_ROWS_COLS_POSITIVE="Error en los datos suministrados";
    public static final String ERROR_ROWS_COLS_POSITIVE="Las filas y/o las columnas deben ser números positivos";

    public static final String MESSAGE_COORD_NOT_VALIDATE="Coordenada inválida";
    public static final String ERROR_COORD_NOT_VALIDATE="La coordena ingresada no se encuentra dentro de las dimensiones" +
            " del tablero";

    public static final String MESSAGE_BOX_OCUPATED="Casilla ocupada";
    public static final String ERROR_BOX_OCUPATED="Ya se encuentra un perro en la coordenada sumnistrada";

    public static final String MESSAGE_BOARD_VOID="Tablero vacío";
    public static final String ERROR_BOARD_VOID="El tablero del juego no ha sido inicializado";

    public static final String MESSAGE_STATE_GAME_INACTIVE="Juego Inactivo";
    public static final String ERROR_STATE_GAME_INACTIVE="El JUEGO NO SE ENCUENTRA INICIADO";
}
