package entregas.celayaIker.Ejercicio2;

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
            System.out.println("Frame " + (posicion + 1) + ":");
            Pixel[][] frame = pantalla[posicion].obtenerFrame();
            for (int y = 0; y < HEIGHT; y++) {
                for (int x = 0; x < WIDTH; x++) {
                    System.out.print(simbolo(frame[x][y].obtenerDato()) + " ");
                }
                System.out.println();
            }
        }
    }

    public void modificarPixel(int frame, int x, int y, int nuevoValor) {
        if (frame >= 0 && frame < pantalla.length) {
            pantalla[frame].modificarPixel(x, y, nuevoValor);
        } else {
            System.out.println("Índice de frame inválido.");
        }
    }

    public void alternarColores() {
        frameActual = 1 - frameActual;
        mostrarFrame(frameActual);
    }

    public void combinarFrames() {
        System.out.println("Resultado visual:");
        Pixel[][] frame1 = pantalla[0].obtenerFrame();
        Pixel[][] frame2 = pantalla[1].obtenerFrame();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(combinarSimbolos(frame1[x][y].obtenerDato(), frame2[x][y].obtenerDato()) + " ");
            }
            System.out.println();
        }
    }
    
    

    private String simbolo(int valor) {
        switch (valor) {
            case 255: return "#"; 
            case 128: return "+";  
            case 64:  return "*"; 
            default:  return "."; 
        }
    }

    private String combinarSimbolos(int valor1, int valor2) {
        if (valor1 == 255 && valor2 == 64) return "@";  
        if (valor1 == 128 && valor2 == 64) return "$";  
        return simbolo(valor1);  
    }
}
