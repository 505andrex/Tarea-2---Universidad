package com.tiendadeservicioselectronicos.sistema.modelo;

import com.tiendadeservicioselectronicos.sistema.excepciones.ValidacionException;

/**
 * Representa un Smartphone, que es un tipo de DispositivoElectronico.
 * Añade propiedades específicas como sistema operativo y número de cámaras.
 */
public class Smartphone extends ElectronicDevice {

    private String operatingSystem;
    private int cameraCount;

    /**
     * Constructor para crear un objeto Smartphone.
     * * @param brand La marca del smartphone.
     * @param model El modelo del smartphone.
     * @param price El precio del smartphone.
     * @param manuFactureYear El año de fabricación.
     * @param operatingSystem El sistema operativo (ej. Android, iOS).
     * @param cameraCount El número de cámaras.
     */
    public Smartphone(String marca, String modelo, double precio, int anioFabricacion, String operatingSystem, int cameraCount) {
        super(marca, modelo, precio, anioFabricacion);
        this.operatingSystem = operatingSystem;
        this.cameraCount = cameraCount;
    }

    // GETTERS Y SETTERS (Con validaciones - Fase 2)

    /**
     * Obtiene el sistema operativo.
     * @return El sistema operativo.
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * Establece el sistema operativo.
     * @param operatingSystem El nombre del SO.
     * @throws IllegalArgumentException si el sistema operativo es nulo o vacío.
     */
    public void setOperatingSystem(String operatingSystem) {
         if (operatingSystem == null || operatingSystem.trim().isEmpty()) {
            throw new IllegalArgumentException("El sistema operativo no puede estar vacío.");
        }
        this.operatingSystem = operatingSystem;
    }

    /**
     * Obtiene el número de cámaras.
     * @return El número de cámaras.
     */
    public int getCameraCount() {
        return cameraCount;
    }

    /**
     * Establece el número de cámaras.
     * @param numCamaras El total de cámaras.
     * @throws ValidacionException si el número de cámaras es negativo.
     */
    public void setCameraCount(int cameraCount) throws ValidacionException {
        if (cameraCount < 0) {
            throw new ValidacionException("El número de cámaras no puede ser negativo.");
        }
        this.cameraCount = cameraCount;
    }

    // MÉTODO PROPIO
    
    /**
     * Simula la acción de hacer una llamada a un número específico.
     * @param number El número de teléfono al que se desea llamar.
     */
    public void makeCall(String number) {
        System.out.println("Llamando al número " + number + " desde el " + getModel() + ".");
    }

    /**
     * Muestra todos los datos del Smartphone, incluyendo los de la clase padre.
     * Llama al método protegido {@link ElectronicDevice#turnOn()}.
     */
    @Override
    public void displayInfo() {
        System.out.println("\n[ Smartphone Creado ]");
        super.displayInfo(); // Llama al método de la clase padre
        System.out.println("Sistema Operativo: " + getOperatingSystem());
        System.out.println("Cámaras: " + getCameraCount());
        
        // Llama al método protegido heredado 
        turnOn(); 
        
        makeCall("555-1234");
    }
}