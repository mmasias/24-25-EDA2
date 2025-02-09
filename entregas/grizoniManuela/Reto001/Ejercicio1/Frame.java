package Reto001.Ejercicio1;

public class Frame {
    private int Altura;
    private int Anchura;
    private PixelList pixelList;

    public Frame(int altura, int anchura) {
        this.Altura = altura;
        this.Anchura = anchura;
        this.pixelList = new PixelList();
    }

    // Método que "pinta" el frame mostrando sus dimensiones y la lista de píxeles
    public void pintar() {
        System.out.println("Frame (" + Altura + "x" + Anchura + "):");
        System.out.println(pixelList);
    }

    public int getAltura() {
        return Altura;
    }

    public int getAnchura() {
        return Anchura;
    }

    public PixelList getPixelList() {
        return pixelList;
    }
}
