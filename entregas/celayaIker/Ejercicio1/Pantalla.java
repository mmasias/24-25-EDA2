package entregas.celayaIker.Ejercicio1;

class Pantalla {
    private Frame[] pantalla;
    private int frameActual;
    private final int WIDTH = 7;
    private final int HEIGHT = 3;

    public Pantalla() {
        pantalla = new Frame[2];
        pantalla[0] = new Frame(WIDTH, HEIGHT);
        pantalla[1] = new Frame(WIDTH, HEIGHT);
        frameActual = 0;
    }

    public void mostrarFrame(int posicion) {
        if (posicion >= 0 && posicion < pantalla.length) {
            System.out.println("Mostrando Frame " + (posicion + 1) + ":");
            for (int y = 0; y < HEIGHT; y++) {
                for (int x = 0; x < WIDTH; x++) {
                    int pos = y * WIDTH + x;
                    System.out.print(simbolo(pantalla[posicion].obtenerPixel(pos).obtenerDato()) + " ");
                }
                System.out.println(); 
            }
        } else {
            System.out.println("Índice de frame inválido.");
        }
    }

    public void modificarPixel(int x, int y, int nuevoValor) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            int pos = y * WIDTH + x;
            pantalla[frameActual].modificarPixel(pos, nuevoValor);
        } else {
            System.out.println("Coordenadas fuera de rango.");
        }
    }

    public void alternarFrames() {
        frameActual = 1 - frameActual;
    }

    public void combinarFrames() {
        System.out.println("Resultado combinado (16x3):");
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(simbolo(pantalla[0].obtenerPixel(y * WIDTH + x).obtenerDato()) + " ");
            }
            System.out.print("  "); 
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(simbolo(pantalla[1].obtenerPixel(y * WIDTH + x).obtenerDato()) + " ");
            }
            System.out.println();
        }
    }

    private String simbolo(int valor) {
        if (valor == 255) return "#";
        if (valor == 128) return "+";
        return ".";
    }
}
