package com.tiendadeservicioselectronicos.sistema.excepciones;

/**
 * Excepción personalizada (checked) que se lanza cuando falla una regla de validación de negocio.
 */
public class ValidacionException extends Exception {
    
/**
     * Constructor que recibe el mensaje de error detallado.
     *
     * @param mensaje El mensaje que describe el error de validación.
     */
    public ValidacionException(String mensaje) {
        super(mensaje);
    }
}