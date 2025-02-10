package Ejercicio1;

class Resultado {
    private char[][] atributos;

    public Resultado() {
        atributos = new char[3][14];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 14; x++) {
                atributos[y][x] = '.';
            }
        }
    }

    public void combinar(Frame frame1, Frame frame2) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 7; x++) {
                atributos[y][x] = frame1.getPixel(x, y);
                atributos[y][x + 7] = frame2.getPixel(x, y);
            }
        }
    }

    public void mostrarResultado() {
        System.out.println("Resultado combinado (14x3)");
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 14; x++) {
                System.out.print(atributos[y][x] + " ");
            }
            System.out.println();
        }
    }
}
