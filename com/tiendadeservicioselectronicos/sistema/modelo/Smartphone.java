/**
 * 505andrex/tarea-2---universidad/Tarea-2---Universidad-c3e9ec4db0b5d444804ea0461e4556badc1a2fda/com/tiendadeservicioselectronicos/sistema/modelo/Smartphone.java
 */
package com.tiendadeservicioselectronicos.sistema.modelo;

import com.tiendadeservicioselectronicos.sistema.excepciones.ValidacionException;

/**
 * Representa un Smartphone, que es un tipo de DispositivoElectronico.
 * Añade propiedades específicas como sistema operativo y número de cámaras.
 */
public class Smartphone extends DispositivoElectronico {

    private String sistemaOperativo;
    private int numCamaras;

    /**
     * Constructor para crear un objeto Smartphone.
     * * @param marca La marca del smartphone.
     * @param modelo El modelo del smartphone.
     * @param precio El precio del smartphone.
     * @param anioFabricacion El año de fabricación.
     * @param sistemaOperativo El sistema operativo (ej. Android, iOS).
     * @param numCamaras El número de cámaras.
     */
    public Smartphone(String marca, String modelo, double precio, int anioFabricacion, String sistemaOperativo, int numCamaras) {
        super(marca, modelo, precio, anioFabricacion);
        this.sistemaOperativo = sistemaOperativo;
        this.numCamaras = numCamaras;
    }

    // GETTERS Y SETTERS (Con validaciones - Fase 2)

    /**
     * Obtiene el sistema operativo.
     * @return El sistema operativo.
     */
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    /**
     * Establece el sistema operativo.
     * @param sistemaOperativo El nombre del SO.
     * @throws IllegalArgumentException si el sistema operativo es nulo o vacío.
     */
    public void setSistemaOperativo(String sistemaOperativo) {
         if (sistemaOperativo == null || sistemaOperativo.trim().isEmpty()) {
            throw new IllegalArgumentException("El sistema operativo no puede estar vacío.");
        }
        this.sistemaOperativo = sistemaOperativo;
    }

    /**
     * Obtiene el número de cámaras.
     * @return El número de cámaras.
     */
    public int getNumCamaras() {
        return numCamaras;
    }

    /**
     * Establece el número de cámaras.
     * @param numCamaras El total de cámaras.
     * @throws ValidacionException si el número de cámaras es negativo.
     */
    public void setNumCamaras(int numCamaras) throws ValidacionException {
        if (numCamaras < 0) {
            throw new ValidacionException("El número de cámaras no puede ser negativo.");
        }
        this.numCamaras = numCamaras;
    }

    // MÉTODO PROPIO
    
    /**
     * Simula la acción de hacer una llamada a un número específico.
     * @param numero El número de teléfono al que se desea llamar.
     */
    public void hacerLlamada(String numero) {
        System.out.println("Llamando al número " + numero + " desde el " + getModelo() + ".");
    }

    /**
     * Muestra todos los datos del Smartphone, incluyendo los de la clase padre.
     * Llama al método protegido {@link DispositivoElectronico#encender()}.
     */
    @Override
    public void mostrarDatos() {
        System.out.println("\n[ Smartphone Creado ]");
        super.mostrarDatos(); // Llama al método de la clase padre
        System.out.println("Sistema Operativo: " + getSistemaOperativo());
        System.out.println("Cámaras: " + getNumCamaras());
        
        // Llama al método protegido heredado (Fase 1)
        encender(); 
        
        hacerLlamada("555-1234");
    }
}