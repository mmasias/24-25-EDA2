package entregas.Reyes_David.Reto001.Ejercicio_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int filas = 3, columnas = 4;

        Frame1 frame1 = new Frame1(filas, columnas);
        Frame2 frame2 = new Frame2(filas, columnas);

        System.out.println("Ingrese los símbolos para el Frame 1 (matriz 3x4):");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Posición [" + i + "][" + j + "]: ");
                char simbolo = scanner.next().charAt(0);
                frame1.addPixel(i, j, simbolo);
            }
        }

        System.out.println("\nIngrese los símbolos para el Frame 2 (matriz 3x4):");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Posición [" + i + "][" + j + "]: ");
                char simbolo = scanner.next().charAt(0);
                frame2.addPixel(i, j, simbolo);
            }
        }

        DobleBuffer dobleBuffer = new DobleBuffer(frame1, frame2);
        Pantalla pantalla = new Pantalla(dobleBuffer);

        System.out.println("\nSimulación de doble buffer con frames alternantes:");
        pantalla.alternarResultados(4); 
        scanner.close();
    }
}
