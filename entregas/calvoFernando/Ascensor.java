package entregas.calvoFernando;

import java.util.Scanner;

public class Ascensor {

    private int plantaActual;

    public Ascensor(int plantaInicial) {
        this.plantaActual = plantaInicial;
    }

    public void irAPlanta(int plantaObjetivo) {
        if (plantaActual == plantaObjetivo) {
            System.out.println("El ascensor ha llegado a la planta: " + plantaObjetivo);
        } else {
            System.out.println("Ascensor moviéndose desde la planta " + plantaActual + " a la planta " + (plantaActual < plantaObjetivo ? plantaActual + 1 : plantaActual - 1));
            
            // Actualizar la planta actual
            plantaActual = plantaActual < plantaObjetivo ? plantaActual + 1 : plantaActual - 1;
            
            // Llamada recursiva para continuar el movimiento
            irAPlanta(plantaObjetivo);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la planta inicial del ascensor: ");
        int plantaInicial = scanner.nextInt();
        
        Ascensor ascensor = new Ascensor(plantaInicial);
        
        System.out.print("Ingrese la planta objetivo a la que desea ir: ");
        int plantaObjetivo = scanner.nextInt();
        
        ascensor.irAPlanta(plantaObjetivo);
        scanner.close();
    }
}
