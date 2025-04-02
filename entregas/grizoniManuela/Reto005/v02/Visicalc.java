package Reto005.v02;

import java.util.Scanner;
import Reto005.librerias.Consola;

public class Visicalc {

    private static final int FILAS = 15;
    private static final int COLUMNAS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] hojaCalculo = new String[FILAS][COLUMNAS];
        int[] posicion = { 0, 0 };
        boolean estaOperativo = true;

        inicializarHojaCalculo(hojaCalculo);

        while (estaOperativo) {

            imprimirHojaCalculo(hojaCalculo, posicion);

            char comando = scanner.next().toUpperCase().charAt(0);

            estaOperativo = procesarComando(comando, hojaCalculo, posicion);
        }

        Consola.limpiarPantalla();
        scanner.close();
    }

    private static void imprimirHojaCalculo(String[][] hojaCalculo, int[] posicion) {

        Consola.limpiarPantalla();
        imprimirOpciones(posicion);
        imprimirCabecerasColumnas();
        imprimirRegla();
        imprimirContenido(hojaCalculo, posicion);
        imprimirRegla();
        Consola.posicionarse(2, 5);
    }

    static void inicializarHojaCalculo(String[][] hojaCalculo) {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                hojaCalculo[fila][columna] = "";
            }
        }
    }

    static void imprimirCabecerasColumnas() {
        System.out.print("      ");
        for (int columna = 0; columna < COLUMNAS; columna++) {
            char letraColumna = (char) ('A' + columna);
            System.out.printf("%-8s", letraColumna);
        }
        System.out.println();
    }

    static void imprimirRegla() {
        System.out.print("     +");
        for (int columna = 0; columna < COLUMNAS; columna++) {
            System.out.print("-------+");
        }
        System.out.println();
    }

    static void imprimirContenido(String[][] hojaCalculo, int[] posicion) {
        int filaActual = posicion[0];
        int columnaActual = posicion[1];

        for (int fila = 0; fila < FILAS; fila++) {
            System.out.printf("%-5d|", fila + 1);

            for (int columna = 0; columna < COLUMNAS; columna++) {
                String celda = hojaCalculo[fila][columna];
                celda = celda.length() > 5 ? celda.substring(0, 5) : String.format("%-5s", celda);

                if (fila == filaActual && columna == columnaActual) {
                    celda = "[" + celda + "]";
                } else {
                    celda = " " + celda + " ";
                }

                System.out.print(celda + "|");
            }
            System.out.println();
        }
    }

    static void imprimirOpciones(int[] posicion) {
        int filaActual = posicion[0];
        int columnaActual = posicion[1];

        System.out.println("DESPLAZAMIENTO: wasd | Edición: e | Salir: q");
        System.out.println("[" + (char) ('A' + columnaActual) + (filaActual + 1) + "] ");
    }

    static boolean procesarComando(char comando, String[][] hojaCalculo, int[] posicion) {
        int filaActual = posicion[0];
        int columnaActual = posicion[1];

        switch (comando) {
            case 'W':
                filaActual = Math.max(filaActual - 1, 0);
                break;
            case 'A':
                columnaActual = Math.max(columnaActual - 1, 0);
                break;
            case 'S':
                filaActual = Math.min(filaActual + 1, FILAS - 1);
                break;
            case 'D':
                columnaActual = Math.min(columnaActual + 1, COLUMNAS - 1);
                break;
            case 'E':
                ingresarTextoEnCelda(hojaCalculo, filaActual, columnaActual);
                break;
            case 'Q':
                System.out.println("Saliendo del programa.");
                return false;
            default:
                System.out.println("Comando inválido. Intente nuevamente.");
        }

        posicion[0] = filaActual;
        posicion[1] = columnaActual;

        return true;
    }

    static void ingresarTextoEnCelda(String[][] hoja, int filaActual, int columnaActual) {
        Scanner scanner = new Scanner(System.in);
        Consola.posicionarse(2, 0);
        System.out.print("Ingrese el texto para [" + (char) ('A' + columnaActual) + (filaActual + 1) + "]:");
        String texto = scanner.next();
        hoja[filaActual][columnaActual] = texto;
        // TODO: #3 He comentado este scanner, pero no debería. Analizar @mmasias
        // scanner.close();  
    }
}