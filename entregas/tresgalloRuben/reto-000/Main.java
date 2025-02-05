import java.util.HashMap;
import java.util.Map;

class Pixel {
    int x;
    int y;
    char color;

    public Pixel(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public char getColor() {
        return this.color;
    }
}

class Frame {
    int Altura;
    int Anchura;
    Pixel[][] Pixeles;

    public Frame(int altura, int anchura) {
        this.Altura = altura;
        this.Anchura = anchura;
        this.Pixeles = new Pixel[altura][anchura];
    }

    public void setPixel(int x, int y, char color) {
        if (x >= 0 && x < Altura && y >= 0 && y < Anchura) {
            Pixeles[x][y] = new Pixel(x, y, color);
        }
    }

    public void renderizar() {
        for (int i = 0; i < Altura; i++) {
            for (int j = 0; j < Anchura; j++) {
                if (Pixeles[i][j] != null) {
                    System.out.print(Pixeles[i][j].getColor() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}

class Superposicion {
    Map<Character, Map<Character, Character>> ColorImagen = new HashMap<>();

    public Superposicion() {
        this.ColorImagen = new HashMap<>();
    }

    public char combinacolores(char color1, char color2) {
        return (color1 != color2) ? '*' : color1; 
    }
}

class Interfaz {
    Frame Frame1;
    Frame Frame2;
    int FrameActual;

    public Interfaz(Frame frame1, Frame frame2, int frameActual) {
        this.Frame1 = frame1;
        this.Frame2 = frame2;
        this.FrameActual = frameActual;
    }

    public void cambiaFrame() {
        FrameActual = (FrameActual == 1) ? 2 : 1;
    }

    public void actualizarPantalla() {
        if (FrameActual == 1) {
            Frame1.renderizar();
        } else {
            Frame2.renderizar();
        }
    }

    public char[] combinaframes() {
        return new char[]{'C', 'O', 'M', 'B', 'I', 'N', 'A'}; 
    }
}

public class Main {
    public static void main(String[] args) {
        Frame frame1 = new Frame(5, 5);
        Frame frame2 = new Frame(5, 5);

        frame1.setPixel(2, 2, 'X');
        frame2.setPixel(3, 3, 'O');

        Interfaz interfaz = new Interfaz(frame1, frame2, 1);
        interfaz.actualizarPantalla();

        interfaz.cambiaFrame();
        interfaz.actualizarPantalla();
    }
}
