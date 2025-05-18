package entregas.PinedaOscar.Reto_005;

import java.util.Arrays;
import java.util.Scanner;

public class HojaDeCalculo {

    private Celda[][] celdas;
    private final int FILAS;
    private final int COLUMNAS;

    public HojaDeCalculo(int numeroFilas, int numeroColumnas) {
        this.FILAS = numeroFilas;
        this.COLUMNAS = numeroColumnas;
        celdas = new Celda[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }

    public Celda getCelda(int fila, int columna) {
        return celdas[fila][columna];
    }

    public int getNumeroDeFilas() {
        return FILAS;
    }

    public int getNumeroDeColumnas() {
        return COLUMNAS;
    }

    public void ordenarColumna(int columna) {
        if (columna < 0 || columna >= COLUMNAS) {
            System.out.println("Columna fuera de rango");
            return;
        }
        
        Arrays.sort(celdas, (fila1, fila2) -> {
            String contenido1 = fila1[columna].getContenido();
            String contenido2 = fila2[columna].getContenido();
            
            try {
                int num1 = Integer.parseInt(contenido1);
                int num2 = Integer.parseInt(contenido2);
                return Integer.compare(num1, num2);
            } catch (NumberFormatException e) {
                return contenido1.compareTo(contenido2);
            }
        });
    }
}