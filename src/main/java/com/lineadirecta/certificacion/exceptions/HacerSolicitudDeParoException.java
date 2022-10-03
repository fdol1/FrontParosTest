package com.lineadirecta.certificacion.exceptions;

import com.lineadirecta.certificacion.utils.Severidad;

import static com.lineadirecta.certificacion.utils.Severidad.SEVERIDAD_MEDIA;

public class HacerSolicitudDeParoException extends RuntimeException{

    private static final Severidad severidad = SEVERIDAD_MEDIA;

    private static final String ERROR = "Error al realizar la solicitud de paro";

    public HacerSolicitudDeParoException(String mensaje, Throwable motivo){
        super(mensaje,motivo);
    }

    public static String Error() {
        return ERROR + "\n Severidad del error: " + severidad;
    }
}