/**
 * 505andrex/tarea-2---universidad/Tarea-2---Universidad-c3e9ec4db0b5d444804ea0461e4556badc1a2fda/com/tiendadeservicioselectronicos/sistema/modelo/DispositivoElectronico.java
 */
package com.tiendadeservicioselectronicos.sistema.modelo;

import com.tiendadeservicioselectronicos.sistema.excepciones.ValidacionException;

/**
 * Clase abstracta que representa un producto genérico en el inventario de la tienda de electrónica.
 * Contiene los atributos y métodos comunes a todos los dispositivos.
 */
public abstract class DispositivoElectronico {
    
    // ATRIBUTOS PRIVADOS (Fase 1)
    private String marca;
    private String modelo;
    private double precio;
    private int anioFabricacion;

    /**
     * Atributo estático para contar el número total de dispositivos creados. (Fase 1)
     */
    private static int contadorDispositivos = 0;

    // CONSTRUCTOR
    /**
     * Constructor para la clase DispositivoElectronico.
     * Incrementa el contador estático de dispositivos.
     * * @param marca La marca del dispositivo.
     * @param modelo El modelo del dispositivo.
     * @param precio El precio del dispositivo.
     * @param anioFabricacion El año de fabricación del dispositivo.
     */
    public DispositivoElectronico(String marca, String modelo, double precio, int anioFabricacion) {
        // Asignación temporal (los setters validarán los datos)
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.anioFabricacion = anioFabricacion;
        
        // Incrementa el contador estático (Fase 1)
        contadorDispositivos++;
    }

    // GETTERS Y SETTERS (Con validaciones - Fase 2)

    /**
     * Obtiene la marca del dispositivo.
     * @return La marca.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del dispositivo.
     * Lanza una excepción si la marca es nula o vacía.
     * * @param marca La marca a establecer.
     * @throws IllegalArgumentException si la marca es nula o está vacía.
     */
    public void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacía.");
        }
        this.marca = marca;
    }

    /**
     * Obtiene el modelo del dispositivo.
     * @return El modelo.
     */
    public String getModelo() {
        return modelo;
    }

   /**
     * Establece el modelo del dispositivo.
     * Lanza una excepción si el modelo es nulo o vacío.
     * * @param modelo El modelo a establecer.
     * @throws IllegalArgumentException si el modelo es nulo o está vacío.
     */
    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío.");
        }
        this.modelo = modelo;
    }

    /**
     * Obtiene el precio del dispositivo.
     * @return El precio.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del dispositivo.
     * Lanza una excepción si el precio es negativo.
     * * @param precio El precio a establecer.
     * @throws ValidacionException si el precio es menor que 0.
     */
    public void setPrecio(double precio) throws ValidacionException {
        if (precio < 0) {
            throw new ValidacionException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    /**
     * Obtiene el año de fabricación del dispositivo.
     * @return El año de fabricación.
     */
    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    /**
     * Establece el año de fabricación.
     * Lanza una excepción si el año es irreal (ej. menor a 1950).
     * * @param anioFabricacion El año a establecer.
     * @throws ValidacionException si el año es menor a 1950.
     */
    public void setAnioFabricacion(int anioFabricacion) throws ValidacionException {
        if (anioFabricacion < 1950) { // Lógica de negocio: no aceptamos dispositivos tan antiguos
            throw new ValidacionException("El año de fabricación debe ser 1950 o posterior.");
        }
        this.anioFabricacion = anioFabricacion;
    }

    // MÉTODOS ESTÁTICOS (Fase 1)
    
    /**
     * Obtiene el conteo total de dispositivos electrónicos creados.
     * @return El número total de instancias de DispositivoElectronico.
     */
    public static int getContadorDispositivos() {
        return contadorDispositivos;
    }

    // MÉTODOS PROTEGIDOS (Fase 1)
    
    /**
     * Simula el encendido del dispositivo.
     * Método protegido, solo visible para las clases hijas.
     */
    protected void encender() {
        System.out.println("El dispositivo " + getModelo() + " se está encendiendo.");
    }

    /**
     * Simula el apagado del dispositivo.
     * Método protegido, solo visible para las clases hijas.
     */
    protected void apagar() {
        System.out.println("El dispositivo " + getModelo() + " se está apagando.");
    }

    /**
     * Muestra los datos comunes del dispositivo en la consola.
     * Este método es público y se espera que las clases hijas lo sobrescriban y lo llamen (super.mostrarDatos()).
     */
    public void mostrarDatos() {
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Año: " + getAnioFabricacion());
    }
}