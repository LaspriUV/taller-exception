package com.example.sesion8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TallerExcepciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Integrantes: \nSantiago Arias Rojas // 2416285 \nSebastian Calvo // 2419118 \nJunior Lasprilla // 2420662");

        do {
            System.out.println("\n=== Taller Excepciones  ===");
            System.out.println("1. Ejercicio 1 - Excepción no controlada");
            System.out.println("2. Ejercicio 2 - Manejo con try-catch");
            System.out.println("3. Ejercicio 3 - Múltiples bloques catch");
            System.out.println("4. Ejercicio 4 - Bloque finally");
            System.out.println("5. Ejercicio 5 - Excepción personalizada FXML");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        ejercicio1();
                        break;
                    case 2:
                        ejercicio2();
                        break;
                    case 3:
                        ejercicio3();
                        break;
                    case 4:
                        ejercicio4();
                        break;
                    case 5:
                        ejercicio5();
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.nextLine();
                opcion = -1;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void ejercicio1() {
        System.out.println("\n--- Ejercicio 1 ---");
        int a = 10;
        int b = 0;
        System.out.println("Resultado: " + (a / b));

        //Obtenemos el manejo de la excepcion hecho por el mismo java, el cual para el programa.
        //La consola muestra: Exception in thread "main" java.lang.ArithmeticException: / by zero
        //	at com.example.sesion8.TallerExcepciones.ejercicio1(TallerExcepciones.java:61)
        //	at com.example.sesion8.TallerExcepciones.main(TallerExcepciones.java:27)
    }

    private static void ejercicio2() {
        System.out.println("\n--- Ejercicio 2 ---");
        int a = 10;
        int b = 0;

        try {
            System.out.println("Resultado: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero no permitida.");
        }
    }

    private static void ejercicio3() {
        System.out.println("\n--- Ejercicio 3 ---");
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese primer número: ");
            int num1 = scanner.nextInt();
            System.out.print("Ingrese segundo número: ");
            int num2 = scanner.nextInt();

            System.out.println("Resultado división: " + (num1 / num2));
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar números enteros.");
        }
    }

    private static void ejercicio4() {
        System.out.println("\n--- Ejercicio 4 ---");
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese primer número: ");
            int num1 = scanner.nextInt();
            System.out.print("Ingrese segundo número: ");
            int num2 = scanner.nextInt();

            System.out.println("Resultado división: " + (num1 / num2));
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar números enteros.");
        } finally {
            System.out.println("Operación finalizada");
            scanner.nextLine();
        }
    }

    private static void ejercicio5() {
        System.out.println("\n--- Ejercicio 5 ---");
        String archivoFXML = "interfaz.fxml";

        try {
            cargarFXML(archivoFXML);
            System.out.println("Archivo FXML cargado correctamente.");
        } catch (FXMLNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void cargarFXML(String nombreArchivo) throws FXMLNotFoundException {
        boolean archivoExiste = false;

        if (!archivoExiste) {
            throw new FXMLNotFoundException("No se encontró el archivo FXML: " + nombreArchivo);
        }
    }
}

class FXMLNotFoundException extends Exception {
    public FXMLNotFoundException(String mensaje) {
        super(mensaje);
    }
}