package com.tiendadeservicioselectronicos.sistema.modelo;

import com.tiendadeservicioselectronicos.sistema.excepciones.ValidacionException;

/**
 * Representa una Laptop, que es un tipo de DispositivoElectronico.
 * Añade propiedades específicas como memoria RAM y si es táctil.
 */
public class Laptop extends ElectronicDevice {
    
    private int ramMemory;
    private boolean isTouchscreen;

    /**
     * Constructor para crear un objeto Laptop.
     * @param brand La marca de la laptop.
     * @param model El modelo de la laptop.
     * @param price El precio de la laptop.
     * @param manufactureYear El año de fabricación.
     * @param ramMemory La cantidad de RAM en GB.
     * @param isTouchscreen Verdadero si la pantalla es tactil.
     */
    public Laptop(String marca, String modelo, double precio, int anioFabricacion, int ramMemory, boolean isTouchscreen) {
        super(marca, modelo, precio, anioFabricacion);
        this.ramMemory = ramMemory;
        this.isTouchscreen = isTouchscreen;
    }

    // GETTERS Y SETTERS (Con validaciones)

    /**
     * Obtiene la cantidad de memoria RAM.
     * @return La RAM en GB.
     */
    public int getRamMemory() {
        return ramMemory;
    }

    /**
     * Establece la cantidad de memoria RAM.
     * @param ramMemory La RAM en GB.
     * @throws ValidacionException si la RAM es 0 o menos.
     */
    public void setRamMemory(int ramMemory) throws ValidacionException {
        if (ramMemory <= 0) {
            throw new ValidacionException("La memoria RAM debe ser un valor positivo (ej. 4, 8, 16).");
        }
        this.ramMemory = ramMemory;
    }

    /**
     * Verifica si la laptop es tactil.
     * @return true si es táctil, false en caso contrario.
     */
    public boolean getisTouchscreen() {
        return isTouchscreen;
    }

    /**
     * Establece si la laptop es táctil.
     * @param isTouchscreen true si es táctil.
     */
    public void setisTouchscreen(boolean isTouchscreen) {
        this.isTouchscreen = isTouchscreen;
    }

    // MÉTODO PROPIO
    
    /**
     * Simula la ejecución de un programa en la laptop.
     * @param nombreApp El nombre de la aplicación a ejecutar.
     */
    public void runProgram(String nombreApp) {
        System.out.println("Ejecutando " + nombreApp + " en la laptop " + getModel() + ".");
    }

    /**
     * Muestra todos los datos de la Laptop, incluyendo los de la clase padre.
     * Llama al método protegido {@link DispositivoElectronico#apagar()}.
     */
    @Override
    public void displayInfo() {
        System.out.println("\n[ Laptop Creada ]");
        super.displayInfo(); // Llama al método de la clase padre
        System.out.println("RAM: " + getRamMemory() + " GB");
        System.out.println("Es Táctil: " + getisTouchscreen());
        
        runProgram("Visual Studio Code");
        
        // Llama al método protegido heredado 
        turnOff();
    }
}