package com.tiendadeservicioselectronicos.sistema.modelo;

public class Smartphone extends DispositivoElectronico{
    /*
     * 
     */
    private String sistemaOperativo;
    private int numCamaras;

    //CONSTRUCTOR
    public Smartphone(String marca, String modelo, double precio, int anioFabricacion, String sistemaOperativo, int numCamaras){
        super(marca, modelo, precio, anioFabricacion);
        this.sistemaOperativo=sistemaOperativo;
        this.numCamaras=numCamaras;
    }

    //GETTERS Y SETTERS
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }
    
    public int getNumCamaras() {
        return numCamaras;
    }

    public void setNumCamaras(int numCamaras) {
        this.numCamaras = numCamaras;
    }
        // METODO PROPIO
    public void hacerLlamada(String numero) {
        System.out.println("Llamando al número " + numero + " desde el " + getModelo() + ".");
    }

    @Override
    public void mostrarDatos(){
        System.out.println("\n[ Smartphone Creado ]");
        super.mostrarDatos();
        System.out.println("Sistema Operativo: " + getSistemaOperativo());
        System.out.println("Cámaras: " + getNumCamaras());
        encender();
        hacerLlamada("555-1234"); 
    }
}