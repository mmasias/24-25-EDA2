import java.util.Random;

public class Color {
    private char representacion;

    public Color() {
        char[] representaciones = {'.', '#', '+', '*'};
        this.representacion = representaciones[new Random().nextInt(representaciones.length)];
    }

    public char devolverRepresentacion() {
        return this.representacion;
    }
}