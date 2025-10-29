/**
 * 505andrex/tarea-2---universidad/Tarea-2---Universidad-c3e9ec4db0b5d444804ea0461e4556badc1a2fda/com/tiendadeservicioselectronicos/sistema/modelo/Laptop.java
 */
package com.tiendadeservicioselectronicos.sistema.modelo;

import com.tiendadeservicioselectronicos.sistema.excepciones.ValidacionException;

/**
 * Representa una Laptop, que es un tipo de DispositivoElectronico.
 * Añade propiedades específicas como memoria RAM y si es táctil.
 */
public class Laptop extends DispositivoElectronico {
    
    private int memoriaRAM;
    private boolean esTactil;

    /**
     * Constructor para crear un objeto Laptop.
     * * @param marca La marca de la laptop.
     * @param modelo El modelo de la laptop.
     * @param precio El precio de la laptop.
     * @param anioFabricacion El año de fabricación.
     * @param memoriaRAM La cantidad de RAM en GB.
     * @param esTactil Verdadero si la pantalla es táctil.
     */
    public Laptop(String marca, String modelo, double precio, int anioFabricacion, int memoriaRAM, boolean esTactil) {
        super(marca, modelo, precio, anioFabricacion);
        this.memoriaRAM = memoriaRAM;
        this.esTactil = esTactil;
    }

    // GETTERS Y SETTERS (Con validaciones - Fase 2)

    /**
     * Obtiene la cantidad de memoria RAM.
     * @return La RAM en GB.
     */
    public int getMemoriaRAM() {
        return memoriaRAM;
    }

    /**
     * Establece la cantidad de memoria RAM.
     * @param memoriaRAM La RAM en GB.
     * @throws ValidacionException si la RAM es 0 o menos.
     */
    public void setMemoriaRAM(int memoriaRAM) throws ValidacionException {
        if (memoriaRAM <= 0) {
            throw new ValidacionException("La memoria RAM debe ser un valor positivo (ej. 4, 8, 16).");
        }
        this.memoriaRAM = memoriaRAM;
    }

    /**
     * Verifica si la laptop es táctil.
     * @return true si es táctil, false en caso contrario.
     */
    public boolean isEsTactil() {
        return esTactil;
    }

    /**
     * Establece si la laptop es táctil.
     * @param esTactil true si es táctil.
     */
    public void setEsTactil(boolean esTactil) {
        this.esTactil = esTactil;
    }

    // MÉTODO PROPIO
    
    /**
     * Simula la ejecución de un programa en la laptop.
     * @param nombreApp El nombre de la aplicación a ejecutar.
     */
    public void ejecutarPrograma(String nombreApp) {
        System.out.println("Ejecutando " + nombreApp + " en la laptop " + getModelo() + ".");
    }

    /**
     * Muestra todos los datos de la Laptop, incluyendo los de la clase padre.
     * Llama al método protegido {@link DispositivoElectronico#apagar()}.
     */
    @Override
    public void mostrarDatos() {
        System.out.println("\n[ Laptop Creada ]");
        super.mostrarDatos(); // Llama al método de la clase padre
        System.out.println("RAM: " + getMemoriaRAM() + " GB");
        System.out.println("Es Táctil: " + isEsTactil());
        
        ejecutarPrograma("Visual Studio Code");
        
        // Llama al método protegido heredado (Fase 1)
        apagar();
    }
}