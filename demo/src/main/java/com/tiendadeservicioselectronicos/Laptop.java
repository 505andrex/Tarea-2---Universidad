package com.tiendadeservicioselectronicos;

public class Laptop {
        //ATRIBUTOS
    private int memoriaRAM;
    private boolean  esTactil;

    //CONSTRUCTOR
    public Laptop(String marca, String modelo, double precio, int anioFabricacion, int memoriaRAM, boolean esTactil){
        super(marca, modelo, precio, anioFabricacion);
        this.memoriaRAM=memoriaRAM;
        this.esTactil=esTactil;
    }

    //GETTERS Y SETTERS
        public int getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(int memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }
    
    public boolean isEsTactil() {
        return esTactil;
    }

    public void setEsTactil(boolean  esTactil) {
        this.esTactil = esTactil;
    }

        // METODO PROPIO
    public void ejecutarPrograma(String nombreApp) {
        System.out.println("Ejecutando " + nombreApp + " en la laptop " + getModelo() + ".");
    }
    @Override
    public void mostrarDatos(){
        System.out.println("\n[ Laptop Creada ]");
        super.mostrarDatos();
        System.out.println("RAM: " + getMemoriaRAM() + " GB");
        System.out.println("Es Táctil: " + isEsTactil());
        ejecutarPrograma("Visual Studio Code");
        apagar();
    }
}
