package com.tiendadeservicioselectronicos.sistema.main;

import java.util.ArrayList;
import java.util.InputMismatchException; 
import java.util.Scanner;

import com.tiendadeservicioselectronicos.sistema.excepciones.ValidacionException; 
import com.tiendadeservicioselectronicos.sistema.modelo.ElectronicDevice;
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
        ArrayList<ElectronicDevice> myDevices = new ArrayList<>();

        // Usamos un bloque try-finally para asegurar que el scanner se cierre
        // incluso si ocurre un error inesperado no capturado.
        try {
            // --- Registro de Smartphone con Manejo de Excepciones---
            Smartphone myPhone = new Smartphone("", "", 0, 0, "", 0);
            System.out.println("\n--- Ingrese los datos del Smartphone ---");

            // Bucle para MARCA (catch IllegalArgumentException)
            while (true) {
                try {
                    System.out.print("Marca: ");
                    myPhone.setBrand(scanner.nextLine());
                    break; // Dato válido, salimos del bucle
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage() + " Intente de nuevo.");
                }
            }
            
            // Bucle para MODELO (catch IllegalArgumentException)
            while (true) {
                try {
                    System.out.print("Modelo: ");
                    myPhone.setModel(scanner.nextLine());
                    break; 
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage() + " Intente de nuevo.");
                }
            }

            // Bucle para PRECIO (catch ValidacionException | InputMismatchException)
            while (true) {
                try {
                    System.out.print("Precio: ");
                    myPhone.setPrice(scanner.nextDouble());
                    break; 
                } catch (ValidacionException e) {
                    System.out.println("Error de validacion: " + e.getMessage() + " Intente de nuevo.");
                } catch (InputMismatchException e) {
                    System.out.println("Error de formato: Debe ingresar un número (ej. 199.99).");
                    scanner.nextLine(); // Limpiar el buffer del scanner
                }
            }

            // Bucle para AÑO (catch ValidacionException | InputMismatchException)
            while (true) {
                try {
                    System.out.print("Año de Fabricación: ");
                    myPhone.setManuFactureYear(scanner.nextInt());
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
                    myPhone.setOperatingSystem(scanner.nextLine());
                    break; 
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage() + " Intente de nuevo.");
                }
            }

            // Bucle para NÚMERO DE CÁMARAS (catch ValidacionException | InputMismatchException)
            while (true) {
                try {
                    System.out.print("Numero de Camaras: ");
                    myPhone.setCameraCount(scanner.nextInt());
                    scanner.nextLine(); // Limpiar el buffer
                    break; 
                } catch (ValidacionException e) {
                    System.out.println("Error de validación: " + e.getMessage() + " Intente de nuevo.");
                } catch (InputMismatchException e) {
                    System.out.println("Error de formato: Debe ingresar un número entero (ej. 3).");
                    scanner.nextLine(); 
                }
            }

            myDevices.add(myPhone);
            System.out.println("¡Smartphone registrado con exito!");

            // --- Registro de Laptop con Manejo de Excepciones ---
            System.out.println("--------------------------------------------------");
            System.out.println("\n--- Ingrese los datos de la Laptop ---");
            Laptop myLaptop = new Laptop("", "", 0, 0, 0, false);
            
            // Bucle para MARCA
            while (true) {
                try {
                    System.out.print("Marca: ");
                    myLaptop.setBrand(scanner.nextLine());
                    break; 
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage() + " Intente de nuevo.");
                }
            }

            // Bucle para MODELO
            while (true) {
                try {
                    System.out.print("Modelo: ");
                    myLaptop.setModel(scanner.nextLine());
                    break; 
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage() + " Intente de nuevo.");
                }
            }

            // Bucle para PRECIO
            while (true) {
                try {
                    System.out.print("Precio: ");
                    myLaptop.setPrice(scanner.nextDouble());
                    break; 
                } catch (ValidacionException e) {
                    System.out.println("Error de validacion: " + e.getMessage() + " Intente de nuevo.");
                } catch (InputMismatchException e) {
                    System.out.println("Error de formato: Debe ingresar un numero (ej. 799.99).");
                    scanner.nextLine(); 
                }
            }

            // Bucle para AÑO
            while (true) {
                try {
                    System.out.print("Anio de Fabricacion: ");
                    myLaptop.setManuFactureYear(scanner.nextInt());
                    break; 
                } catch (ValidacionException e) {
                    System.out.println("Error de validacion: " + e.getMessage() + " Intente de nuevo.");
                } catch (InputMismatchException e) {
                    System.out.println("Error de formato: Debe ingresar un numero entero (ej. 2022).");
                    scanner.nextLine(); 
                }
            }

            // Bucle para RAM
            while (true) {
                try {
                    System.out.print("Memoria RAM (en GB): ");
                    myLaptop.setRamMemory(scanner.nextInt());
                    break; 
                } catch (ValidacionException e) {
                    System.out.println("Error de validacion: " + e.getMessage() + " Intente de nuevo.");
                } catch (InputMismatchException e) {
                    System.out.println("Error de formato: Debe ingresar un número entero (ej. 16).");
                    scanner.nextLine(); 
                }
            }

            // Bucle para ¿ES TÁCTIL? (catch InputMismatchException)
            while (true) {
                try {
                    System.out.print("¿Es Táctil? (true/false): ");
                    myLaptop.setisTouchscreen(scanner.nextBoolean());
                    scanner.nextLine(); // Limpiar el buffer
                    break; 
                } catch (InputMismatchException e) {
                    System.out.println("Error de formato: Debe ingresar 'true' o 'false'.");
                    scanner.nextLine(); 
                }
            }
            
            myDevices.add(myLaptop);
            System.out.println("¡Laptop registrada con exito!");


            // --- Mostrar Dispositivos Registrados ---
            System.out.println("--------------------------------------------------");
            System.out.println("\n--- Dispositivos Registrados ---");
            for (ElectronicDevice m : myDevices) {
                m.displayInfo();
                System.out.println("--------------------------------------------------");
            }

            // --- Mostrar Conteo Estático ---
            System.out.println("\nTotal de dispositivos creados en esta sesión: " + 
            ElectronicDevice.getDeviceCounter());

        } catch (Exception e) {
            // Captura genérica para cualquier error fatal imprevisto.
            System.out.println("Ha ocurrido un error inesperado y el programa se cerrara.");
            e.printStackTrace();
        } finally {

            System.out.println("\nCerrando el scanner...");
            scanner.close();
        }
    }
}