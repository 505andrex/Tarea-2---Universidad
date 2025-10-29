/**
 * 505andrex/tarea-2---universidad/Tarea-2---Universidad-c3e9ec4db0b5d444804ea0461e4556badc1a2fda/com/tiendadeservicioselectronicos/sistema/main/Main.java
 */
package com.tiendadeservicioselectronicos.sistema.main;

import java.util.ArrayList;
import java.util.InputMismatchException; // Importado para Fase 2
import java.util.Scanner;

import com.tiendadeservicioselectronicos.sistema.excepciones.ValidacionException; // Importado para Fase 2
import com.tiendadeservicioselectronicos.sistema.modelo.DispositivoElectronico;
import com.tiendadeservicioselectronicos.sistema.modelo.Laptop;
import com.tiendadeservicioselectronicos.sistema.modelo.Smartphone;

/**
 * Clase principal para ejecutar el sistema de inventario de la tienda.
 * Permite al usuario registrar un Smartphone y una Laptop, manejando
 * errores de entrada y validación.
 */
public class Main {

    /**
     * Método principal que inicia la aplicación.
     * @param args Argumentos de la línea de comandos (no se usan).
     */
    public static void main(String[] args) {
        System.out.println("Bienvenido al Sistema de Inventario v2.0");

        Scanner scanner = new Scanner(System.in);
        ArrayList<DispositivoElectronico> misDispositivos = new ArrayList<>();

        // Usamos un bloque try-finally para asegurar que el scanner se cierre
        // incluso si ocurre un error inesperado no capturado.
        try {
            // --- Registro de Smartphone con Manejo de Excepciones (Fase 2) ---
            Smartphone miTelefono = new Smartphone("", "", 0, 0, "", 0);
            System.out.println("\n--- Ingrese los datos del Smartphone ---");

            // Bucle para MARCA (catch IllegalArgumentException)
            while (true) {
                try {
                    System.out.print("Marca: ");
                    miTelefono.setMarca(scanner.nextLine());
                    break; // Dato válido, salimos del bucle
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage() + " Intente de nuevo.");
                }
            }
            
            // Bucle para MODELO (catch IllegalArgumentException)
            while (true) {
                try {
                    System.out.print("Modelo: ");
                    miTelefono.setModelo(scanner.nextLine());
                    break; 
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage() + " Intente de nuevo.");
                }
            }

            // Bucle para PRECIO (catch ValidacionException | InputMismatchException)
            while (true) {
                try {
                    System.out.print("Precio: ");
                    miTelefono.setPrecio(scanner.nextDouble());
                    break; 
                } catch (ValidacionException e) {
                    System.out.println("Error de validación: " + e.getMessage() + " Intente de nuevo.");
                } catch (InputMismatchException e) {
                    System.out.println("Error de formato: Debe ingresar un número (ej. 199.99).");
                    scanner.nextLine(); // Limpiar el buffer del scanner
                }
            }

            // Bucle para AÑO (catch ValidacionException | InputMismatchException)
            while (true) {
                try {
                    System.out.print("Año de Fabricación: ");
                    miTelefono.setAnioFabricacion(scanner.nextInt());
                    scanner.nextLine(); // Limpiar el buffer (consume el \n)
                    break; 
                } catch (ValidacionException e) {
                    System.out.println("Error de validación: " + e.getMessage() + " Intente de nuevo.");
                } catch (InputMismatchException e) {
                    System.out.println("Error de formato: Debe ingresar un número entero (ej. 2023).");
                    scanner.nextLine(); 
                }
            }

            // Bucle para SISTEMA OPERATIVO (catch IllegalArgumentException)
            while (true) {
                try {
                    System.out.print("Sistema Operativo (ej. Android, iOS): ");
                    miTelefono.setSistemaOperativo(scanner.nextLine());
                    break; 
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage() + " Intente de nuevo.");
                }
            }

            // Bucle para NÚMERO DE CÁMARAS (catch ValidacionException | InputMismatchException)
            while (true) {
                try {
                    System.out.print("Número de Cámaras: ");
                    miTelefono.setNumCamaras(scanner.nextInt());
                    scanner.nextLine(); // Limpiar el buffer
                    break; 
                } catch (ValidacionException e) {
                    System.out.println("Error de validación: " + e.getMessage() + " Intente de nuevo.");
                } catch (InputMismatchException e) {
                    System.out.println("Error de formato: Debe ingresar un número entero (ej. 3).");
                    scanner.nextLine(); 
                }
            }

            misDispositivos.add(miTelefono);
            System.out.println("¡Smartphone registrado con éxito!");

            // --- Registro de Laptop con Manejo de Excepciones ---
            System.out.println("--------------------------------------------------");
            System.out.println("\n--- Ingrese los datos de la Laptop ---");
            Laptop miLaptop = new Laptop("", "", 0, 0, 0, false);
            
            // Bucle para MARCA
            while (true) {
                try {
                    System.out.print("Marca: ");
                    miLaptop.setMarca(scanner.nextLine());
                    break; 
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage() + " Intente de nuevo.");
                }
            }

            // Bucle para MODELO
            while (true) {
                try {
                    System.out.print("Modelo: ");
                    miLaptop.setModelo(scanner.nextLine());
                    break; 
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage() + " Intente de nuevo.");
                }
            }

            // Bucle para PRECIO
            while (true) {
                try {
                    System.out.print("Precio: ");
                    miLaptop.setPrecio(scanner.nextDouble());
                    break; 
                } catch (ValidacionException e) {
                    System.out.println("Error de validación: " + e.getMessage() + " Intente de nuevo.");
                } catch (InputMismatchException e) {
                    System.out.println("Error de formato: Debe ingresar un número (ej. 799.99).");
                    scanner.nextLine(); 
                }
            }

            // Bucle para AÑO
            while (true) {
                try {
                    System.out.print("Año de Fabricación: ");
                    miLaptop.setAnioFabricacion(scanner.nextInt());
                    break; 
                } catch (ValidacionException e) {
                    System.out.println("Error de validación: " + e.getMessage() + " Intente de nuevo.");
                } catch (InputMismatchException e) {
                    System.out.println("Error de formato: Debe ingresar un número entero (ej. 2022).");
                    scanner.nextLine(); 
                }
            }

            // Bucle para RAM
            while (true) {
                try {
                    System.out.print("Memoria RAM (en GB): ");
                    miLaptop.setMemoriaRAM(scanner.nextInt());
                    break; 
                } catch (ValidacionException e) {
                    System.out.println("Error de validación: " + e.getMessage() + " Intente de nuevo.");
                } catch (InputMismatchException e) {
                    System.out.println("Error de formato: Debe ingresar un número entero (ej. 16).");
                    scanner.nextLine(); 
                }
            }

            // Bucle para ¿ES TÁCTIL? (catch InputMismatchException)
            while (true) {
                try {
                    System.out.print("¿Es Táctil? (true/false): ");
                    miLaptop.setEsTactil(scanner.nextBoolean());
                    scanner.nextLine(); // Limpiar el buffer
                    break; 
                } catch (InputMismatchException e) {
                    System.out.println("Error de formato: Debe ingresar 'true' o 'false'.");
                    scanner.nextLine(); 
                }
            }
            
            misDispositivos.add(miLaptop);
            System.out.println("¡Laptop registrada con éxito!");


            // --- Mostrar Dispositivos Registrados ---
            System.out.println("--------------------------------------------------");
            System.out.println("\n--- Dispositivos Registrados ---");
            for (DispositivoElectronico m : misDispositivos) {
                m.mostrarDatos();
                System.out.println("--------------------------------------------------");
            }

            // --- Mostrar Conteo Estático ---
            System.out.println("\nTotal de dispositivos creados en esta sesión: " + 
            DispositivoElectronico.getContadorDispositivos());

        } catch (Exception e) {
            // Captura genérica para cualquier error fatal imprevisto.
            System.out.println("Ha ocurrido un error inesperado y el programa se cerrará.");
            e.printStackTrace();
        } finally {

            System.out.println("\nCerrando el scanner...");
            scanner.close();
        }
    }
}