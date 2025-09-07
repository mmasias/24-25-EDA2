package Reto001.Ejercicio2;

public class Pixel {
    private char resultado;

    public Pixel(char resultado) {
        this.resultado = resultado;
    }

    public char getResultado() {
        return resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return Character.toString(resultado);
    }
}
