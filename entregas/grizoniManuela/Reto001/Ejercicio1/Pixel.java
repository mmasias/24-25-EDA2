package Reto001.Ejercicio1;

public class Pixel {
    private char valor;

    public Pixel(char valor) {
        this.valor = valor;
    }

    public char getValor() {
        return valor;
    }

    public void setValor(char valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return Character.toString(valor);
    }
}
