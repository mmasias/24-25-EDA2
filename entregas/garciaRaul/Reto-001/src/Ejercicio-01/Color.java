import java.util.Random;

public class Color {

    private char representacion;

    public Color() {
        char[] representaciones = {'.', '#', '+', '*'};

        int indice = new Random().nextInt(representaciones.length);

        this.representacion = representaciones[indice];
    }

    public char devolverRepresentacion() {
        return this.representacion;
    }
}