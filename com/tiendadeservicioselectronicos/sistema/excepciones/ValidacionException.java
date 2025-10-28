package com.tiendadeservicioselectronicos.sistema.excepciones;
/*
 * constructor que recibe el mensaje de error
 */
public class ValidacionException extends Exception{
    /**
     * Constructor que recibe el mensaje de error.
     *
     * @param mensaje El mensaje detallado del error.
     */
    public ValidacionException(String mensaje) {
        super(mensaje);
    }
}
