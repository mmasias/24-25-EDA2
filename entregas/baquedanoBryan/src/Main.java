public class Main {
    public static void main(String[] args) {
        int filas = 15;
        int columnas = 20;

        Frame frame1 = new Frame(filas, columnas);
        Frame frame2 = new Frame(filas, columnas);

        String[] florParteSuperior = {
            "    ·       ·     ·  ",
            "            ·        ",
            "   ·      ·    ·     ",
            "                     ",
            "       ·       ·     ",
            "         @@@         ",
            "   ·   @@@@@@@      ",
            "      @@@@@@@@@      ",
            "       @@@@@@@       ",
            "         @@@         ",
            "         ###         ",
            "                     ",
            "         ###         ",
            "                     ",
            "         ###         ",
        };

        String[] florParteInferior = {
            "         ###         ",
            "                     ",
            "         ###         ",
            "                     ",
            "  @@@@@@@###@@@@@@@  ",
            "                     ",
            "    @@@@@###@@@@@    ",
            "                     ",
            "         ###         ",
            "                     ",
            "         ###         ",
            "                     ",
            "         ###         ",
            "                     ",
            "@@@@@@@@@###@@@@@@@@@",
        };

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                char simboloSuperior = florParteSuperior[i].charAt(j);
                char simboloInferior = florParteInferior[i].charAt(j);

                frame1.pixeles[i][j] = new Pixel(simboloSuperior, ' ', ' ');
                frame2.pixeles[i][j] = new Pixel(simboloInferior, ' ', ' ');
            }
        }

        Nodo nodo1 = new Nodo(frame1, null, null);
        Nodo nodo2 = new Nodo(frame2, null, nodo1);
        nodo1.siguiente = nodo2;
        nodo2.anterior = nodo1;

        Pantalla pantalla = new Pantalla(500);
        pantalla.cabeza = nodo1;
        pantalla.cola = nodo2;

        pantalla.alternanciaImpresion();
    }
}
