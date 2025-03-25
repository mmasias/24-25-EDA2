package Ascensor;

import java.util.Scanner;

public class Ascensor {
    public static void main(String[] args) {
        int pisoMin = 0;
        int pisoMax = 5;
        int pisoActual = 0;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simulación del ascensor:\n");
        
        while (true) {
            System.out.println("Estás en el piso " + pisoActual + ". Introduce el piso al que deseas ir (" 
                               + pisoMin + " - " + pisoMax + ") o -1 para salir:");
            int pisoDestino = scanner.nextInt();
            
            if (pisoDestino == -1) {
                System.out.println("Saliendo de la simulación.");
                break;
            }
            if (pisoDestino < pisoMin || pisoDestino > pisoMax) {
                System.out.println("Piso no válido. Intenta de nuevo.\n");
                continue;
            }
            if (pisoDestino == pisoActual) {
                System.out.println("Ya estás en ese piso.\n");
                continue;
            }
            
            if (pisoDestino > pisoActual) {
                pisoActual = subirAscensor(pisoActual, pisoDestino);
            } else {
                pisoActual = bajarAscensor(pisoActual, pisoDestino);
            }
            System.out.println();
        }
        
        scanner.close();
    }
    
    public static int subirAscensor(int pisoActual, int pisoDestino) {
        if (pisoActual == pisoDestino) {
            detenerEnPiso(pisoActual);
            return pisoActual;
        } else {
            System.out.println("Moviéndose desde piso " + pisoActual + " al piso " + (pisoActual + 1));
            moverAscensor();
            return subirAscensor(pisoActual + 1, pisoDestino);
        }
    }
    
    public static int bajarAscensor(int pisoActual, int pisoDestino) {
        if (pisoActual == pisoDestino) {
            detenerEnPiso(pisoActual);
            return pisoActual;
        } else {
            System.out.println("Moviéndose desde piso " + pisoActual + " al piso " + (pisoActual - 1));
            moverAscensor();
            return bajarAscensor(pisoActual - 1, pisoDestino);
        }
    }
    
    public static void detenerEnPiso(int piso) {
        System.out.println("Piso " + piso + ": Puertas abriendo.");
        esperar(1000); 
        System.out.println("Piso " + piso + ": Puertas cerrando.");
        esperar(500);  
    }
    
    public static void moverAscensor() {
        System.out.println("Ascensor en movimiento...");
        esperar(1000); 
    }
    

    public static void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
