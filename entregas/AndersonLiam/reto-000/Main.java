import java.util.ArrayList;
import java.util.List;


class Pixel {
    private int x;
    private int y;
    private String color;

    public Pixel(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


class Frame {
    private Pixel[][] pixels;
    private int ancho;
    private int alto;

    public Frame(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.pixels = new Pixel[ancho][alto];
        inicializarPixels();
    }

    private void inicializarPixels() {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                pixels[i][j] = new Pixel(i, j, "Blanco");
            }
        }
    }

    public Pixel obtenerPixel(int x, int y) {
        if (x >= 0 && x < ancho && y >= 0 && y < alto) {
            return pixels[x][y];
        }
        return null;
    }

    public void establecerPixel(int x, int y, String color) {
        if (x >= 0 && x < ancho && y >= 0 && y < alto) {
            pixels[x][y].setColor(color);
        }
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}


class ControlDeEnlazado {
    private Frame frame1;
    private Frame frame2;
    private Frame frameRestante;

    public void establecerFrames(Frame f1, Frame f2) {
        this.frame1 = f1;
        this.frame2 = f2;
        combinarFrames();
    }

    private void combinarFrames() {
        if (frame1 != null && frame2 != null) {
            int ancho = Math.min(frame1.getAncho(), frame2.getAncho());
            int alto = Math.min(frame1.getAlto(), frame2.getAlto());
            frameRestante = new Frame(ancho, alto);

            for (int i = 0; i < ancho; i++) {
                for (int j = 0; j < alto; j++) {
                    if (i % 2 == 0) {
                        frameRestante.establecerPixel(i, j, frame1.obtenerPixel(i, j).getColor());
                    } else {
                        frameRestante.establecerPixel(i, j, frame2.obtenerPixel(i, j).getColor());
                    }
                }
            }
        }
    }

    public Frame getFrameRestante() {
        return frameRestante;
    }
}


class Pantalla {
    private List<Frame> frames;

    public Pantalla() {
        this.frames = new ArrayList<>();
    }

    public void mostrarFrame(Frame frame) {
        System.out.println("Mostrando frame:");
        for (int y = 0; y < frame.getAlto(); y++) {
            for (int x = 0; x < frame.getAncho(); x++) {
                System.out.print(frame.obtenerPixel(x, y).getColor().charAt(0) + " ");
            }
            System.out.println();
        }
    }

    public void agregarFrame(Frame frame) {
        frames.add(frame);
    }
}


public class Main {
    public static void main(String[] args) {
     
        Frame frame1 = new Frame(5, 5);
        Frame frame2 = new Frame(5, 5);

        frame1.establecerPixel(0, 0, "Rojo");
        frame1.establecerPixel(1, 1, "Verde");
        frame2.establecerPixel(0, 0, "Azul");
        frame2.establecerPixel(1, 1, "Amarillo");

       
        ControlDeEnlazado controlador = new ControlDeEnlazado();
        controlador.establecerFrames(frame1, frame2);

      
        Frame frameCombinado = controlador.getFrameRestante();

        
        Pantalla pantalla = new Pantalla();
        pantalla.agregarFrame(frame1);
        pantalla.agregarFrame(frame2);
        pantalla.mostrarFrame(frameCombinado);
    }
}
