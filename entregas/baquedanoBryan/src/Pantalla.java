public class Pantalla {
    private Nodo cabeza;
    private Nodo cola;
    private int timer;

    public Pantalla(int timer) {
        this.timer = timer > 0 ? timer : 1000;
        configurarFramesFlor();
    }

    private void configurarFramesFlor() {
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
            "         ###         ",
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

        this.cabeza = nodo1;
        this.cola = nodo2;
    }

    public void alternanciaImpresion() {
        if (cabeza == null || cola == null) {
            System.out.println("Error: No hay suficientes Frames para alternar.");
            return;
        }

        boolean mostrarPrimero = true;

        while (true) { 

            if (mostrarPrimero) {
                imprimirFrameIndividual(cabeza.dato);
            } else {
                imprimirFrameIndividual(cola.dato);
            }

            mostrarPrimero = !mostrarPrimero;

            try {
                Thread.sleep(timer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void imprimirFrameIndividual(Frame frame) {
        for (int i = 0; i < frame.pixeles.length; i++) {
            for (int j = 0; j < frame.pixeles[i].length; j++) {
                System.out.print(frame.pixeles[i][j].getNumeral() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
