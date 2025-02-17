package Ejercicio02;

import java.util.Random;

public class Color {

    private char[] representacion = {'.', ',', ':', ';', '+', '=', '*', '&', '#'};
    private int valor;
    private char colorSeleccionado;

    public Color() {
        this.valor = new Random().nextInt(4);
        this.colorSeleccionado = representacion[this.valor];
    }

    public Color(int valor) {
        if (valor >= 0 && valor < representacion.length) {
            this.valor = valor;
            this.colorSeleccionado = this.representacion[valor];
        } else {
            this.valor = 0;
            this.colorSeleccionado = this.representacion[0];
        }
    }

    public int devolverValor() {
        return this.valor;
    }

    public char devolverRepresentacion() {
        return this.colorSeleccionado;
    }
}
