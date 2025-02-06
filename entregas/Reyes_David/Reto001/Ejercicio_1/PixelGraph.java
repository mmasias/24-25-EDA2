package entregas.Reyes_David.Reto001.Ejercicio_1;

import java.util.*;

public class PixelGraph {
    private int filas;
    private int columnas;
    private Map<String, Pixel> pixeles;

    public PixelGraph(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.pixeles = new HashMap<>();
    }

    public void addPixel(int fila, int columna, char simbolo) {
        String key = fila + "," + columna;
        pixeles.put(key, new Pixel(simbolo));
    }

    public void mostrarPixeles() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String key = i + "," + j;
                System.out.print(pixeles.get(key).getSimbolo() + " ");
            }
            System.out.println();
        }
    }
}
