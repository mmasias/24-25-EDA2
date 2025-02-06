package entregas.Reyes_David.Reto001.Ejercicio_2;

import java.util.Scanner;

public class Frame {
    private Pixel[][] matriz;
    private int filas;
    private int columnas;

    public Frame(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new Pixel[filas][columnas];
        inicializarMatriz();
    }

    private void inicializarMatriz() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = new Pixel('.');
            }
        }
    }

    public void seleccionarColores() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los colores para el frame (., #, +, *):");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Pixel[" + i + "][" + j + "]: ");
                char color = scanner.next().charAt(0);
                matriz[i][j].setColor(color);
            }
        }
    }

    public Pixel[][] getMatriz() {
        return matriz;
    }
}
