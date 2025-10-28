package com.tiendadeservicioselectronicos.sistema.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.tiendadeservicioselectronicos.sistema.modelo.DispositivoElectronico;
import com.tiendadeservicioselectronicos.sistema.modelo.Laptop;
import com.tiendadeservicioselectronicos.sistema.modelo.Smartphone; 
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Scanner scanner = new Scanner(System.in);
        ArrayList<DispositivoElectronico> misDispositivos = new ArrayList<>();

        Smartphone miTelefono = new Smartphone("", "", 0, 0, "", 0);
        System.out.println("--- Ingrese los datos del Smartphone ---");
        
        System.out.print("Marca: ");
        miTelefono.setMarca(scanner.nextLine());
        
        System.out.print("Modelo: ");
        miTelefono.setModelo(scanner.nextLine());
        
        System.out.print("Precio: ");
        miTelefono.setPrecio(scanner.nextDouble());
        
        System.out.print("Año de Fabricación: ");
        miTelefono.setAnioFabricacion(scanner.nextInt()); scanner.nextLine();
        
        System.out.print("Sistema Operativo (ej. Android, iOS): ");
        miTelefono.setSistemaOperativo(scanner.nextLine());
        
        System.out.print("Número de Cámaras: ");
        miTelefono.setNumCamaras(scanner.nextInt());

        misDispositivos.add(miTelefono);

        System.out.println("--------------------------------------------------");
        System.out.println("\n--- Ingrese los datos de la Laptop ---");
        
        Laptop miLaptop = new Laptop("", "", 0, 0, 0, false);
        scanner.nextLine(); 
        
        System.out.print("Marca: ");
        miLaptop.setMarca(scanner.nextLine());
        
        System.out.print("Modelo: ");
        miLaptop.setModelo(scanner.nextLine());

        
        System.out.print("Precio: ");
        miLaptop.setPrecio(scanner.nextDouble());

        
        System.out.print("Año de Fabricación: ");
        miLaptop.setAnioFabricacion(scanner.nextInt());
        
        System.out.print("Memoria RAM (en GB): ");
        miLaptop.setMemoriaRAM(scanner.nextInt());
        
        System.out.print("¿Es Táctil? (true/false): ");
        miLaptop.setEsTactil(scanner.nextBoolean());

        misDispositivos.add(miLaptop);

        System.out.println("--------------------------------------------------");
        System.out.println("\n--- Dispositivos Registrados ---");
        for(DispositivoElectronico m : misDispositivos){
            m.mostrarDatos();
        System.out.println("--------------------------------------------------");
        }

        scanner.close();
    }
}