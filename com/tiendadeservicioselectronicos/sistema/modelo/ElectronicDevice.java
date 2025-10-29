package com.tiendadeservicioselectronicos.sistema.modelo;

import com.tiendadeservicioselectronicos.sistema.excepciones.ValidacionException;

/**
 * Clase abstracta que representa un producto genérico en el inventario de la tienda de electrónica.
 * Contiene los atributos y métodos comunes a todos los dispositivos.
 */
public abstract class ElectronicDevice {
    
    private String brand; //marca
    private String model; //modelo
    private double price; //precio
    private int manufactureYear; //año de fabricaciom

    /**
     * Atributo estático para contar el número total de dispositivos creados. 
     */
    private static int deviceCounter = 0;

    // CONSTRUCTOR
    /**
     * Constructor para la clase DispositivoElectronico.
     * Incrementa el contador estático de dispositivos.
     * * @param brand La marca del dispositivo.
     * @param model El modelo del dispositivo.
     * @param price El precio del dispositivo.
     * @param manufactureYear El año de fabricación del dispositivo.
     */
    public ElectronicDevice(String brand, String model, double price, int manufactureYear) {
        // Asignación temporal (los setters validarán los datos)
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.manufactureYear = manufactureYear;
        
        // Incrementa el contador estático 
        deviceCounter++;
    }

        // GETTERS Y SETTERS (Con validaciones)

    /**
     * Obtiene la marca del dispositivo.
     * @return La marca.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Establece la marca del dispositivo.
     * Lanza una excepción si la marca es nula o vacía.
     * * @param brand La marca a establecer.
     * @throws IllegalArgumentException si la marca es nula o está vacía.
     */
    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacia.");
        }
        this.brand = brand;
    }

    /**
     * Obtiene el modelo del dispositivo.
     * @return El modelo.
     */
    public String getModel() {
        return model;
    }

   /**
     * Establece el modelo del dispositivo.
     * Lanza una excepción si el modelo es nulo o vacío.
     * * @param model El modelo a establecer.
     * @throws IllegalArgumentException si el modelo es nulo o está vacío.
     */
    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacio.");
        }
        this.model = model;
    }

    /**
     * Obtiene el precio del dispositivo.
     * @return El precio.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Establece el precio del dispositivo.
     * Lanza una excepción si el precio es negativo.
     * * @param price El precio a establecer.
     * @throws ValidacionException si el precio es menor que 0.
     */
    public void setPrice(double price) throws ValidacionException {
        if (price < 0) {
            throw new ValidacionException("El precio no puede ser negativo.");
        }
        this.price = price;
    }

    /**
     * Obtiene el año de fabricación del dispositivo.
     * @return El año de fabricación.
     */
    public int getManuFactureYear() {
        return manufactureYear;
    }

    /**
     * Establece el año de fabricación.
     * Lanza una excepción si el año es irreal (ej. menor a 1950).
     * * @param manufactureYear El año a establecer.
     * @throws ValidacionException si el año es menor a 1950.
     */
    public void setManuFactureYear(int manufactureYear) throws ValidacionException {
        if (manufactureYear < 1950) { // Lógica de negocio: no aceptamos dispositivos tan antiguos
            throw new ValidacionException("El año de fabricación debe ser 1950 o posterior.");
        }
        this.manufactureYear = manufactureYear;
    }

    // MÉTODOS ESTÁTICOS 
    
    /**
     * Obtiene el conteo total de dispositivos electrónicos creados.
     * @return El número total de instancias de DispositivoElectronico.
     */
    public static int getDeviceCounter() {
        return deviceCounter;
    }

    // MÉTODOS PROTEGIDOS (Fase 1)
    
    /**
     * Simula el encendido del dispositivo.
     * Método protegido, solo visible para las clases hijas.
     */
    protected void turnOn() {
        System.out.println("El dispositivo " + getModel() + " se esta encendiendo.");
    }

    /**
     * Simula el apagado del dispositivo.
     * Método protegido, solo visible para las clases hijas.
     */
    protected void turnOff() {
        System.out.println("El dispositivo " + getModel() + " se esta apagando.");
    }

    /**
     * Muestra los datos comunes del dispositivo en la consola.
     * Este método es público y se espera que las clases hijas lo sobrescriban y lo llamen (super.mostrarDatos()).
     */
    public void displayInfo() {
        System.out.println("Marca: " + getBrand());
        System.out.println("Modelo: " + getModel());
        System.out.println("Precio: $" + getPrice());
        System.out.println("Año: " + getManuFactureYear());
    }
}