package Reto001.Ejercicio2;

public class Frame {
    private int Altura;
    private int Anchura;
    private PixelList pixelList;

    public Frame(int altura, int anchura, PixelList pixelList) {
        this.Altura = altura;
        this.Anchura = anchura;
        this.pixelList = pixelList;
    }

    public void PintarNegro() {
        System.out.println("Pintando frame en NEGRO.");
        pixelList.updateAllPixels('N');
    }

    public void PintarBlanco() {
        System.out.println("Pintando frame en BLANCO.");
        pixelList.updateAllPixels('B');
    }

    public void PintarCyan() {
        System.out.println("Pintando frame en CYAN.");
        pixelList.updateAllPixels('C');
    }

    public void PintarMagenta() {
        System.out.println("Pintando frame en MAGENTA.");
        pixelList.updateAllPixels('M');
    }

    public void TiempoDeAlternancia() {
        System.out.println("Ejecutando Tiempo de Alternancia:");
        PintarBlanco();
        PintarNegro();
        PintarCyan();
        PintarMagenta();
    }

    public PixelList getPixelList() {
        return pixelList;
    }

    public void displayFrameInfo() {
        System.out.println("Frame de tamaño " + Altura + "x" + Anchura);
        System.out.println("Contenido de píxeles: " + pixelList);
    }
}

