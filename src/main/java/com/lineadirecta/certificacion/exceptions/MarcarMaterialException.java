package com.lineadirecta.certificacion.exceptions;

import com.lineadirecta.certificacion.utils.Severidad;

import static com.lineadirecta.certificacion.utils.Severidad.SEVERIDAD_MEDIA;

public class MarcarMaterialException extends RuntimeException{

    private static final Severidad severidad = SEVERIDAD_MEDIA;

    private static final String ERROR = "Error al marcar el material";

    public MarcarMaterialException(String mensaje, Throwable motivo){
        super(mensaje,motivo);
    }

    public static String Error() {
        return ERROR + "\n Severidad del error: " + severidad;
    }
}