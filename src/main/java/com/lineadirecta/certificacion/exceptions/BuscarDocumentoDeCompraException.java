package com.lineadirecta.certificacion.exceptions;


import com.lineadirecta.certificacion.utils.Severidad;

import static com.lineadirecta.certificacion.utils.Severidad.SEVERIDAD_MEDIA;

public class BuscarDocumentoDeCompraException extends RuntimeException{

    private static final Severidad severidad = SEVERIDAD_MEDIA;

    private static final String ERROR = "Error al buscar documento de compra";

    public BuscarDocumentoDeCompraException(String mensaje, Throwable motivo){
        super(mensaje,motivo);
    }

    public static String Error() {
        return ERROR;
    }
}