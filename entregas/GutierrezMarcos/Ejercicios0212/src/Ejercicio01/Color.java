package Ejercicio01;

import java.util.Random;

public class Color {

    private char[] representacion = {'.', '#', '+', '*'};

    private char colorSeleccionado;

    public Color() {
        this.colorSeleccionado = representacion[new Random().nextInt(representacion.length)];
    }

    public char devolverRepresentacion() {
        return this.colorSeleccionado;
    }
}
