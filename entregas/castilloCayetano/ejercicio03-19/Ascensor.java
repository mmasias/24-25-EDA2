public class Ascensor {
    private static final int PISO_MINIMO = 0;
    private static final int PISO_MAXIMO = 10;

    public void subir(int pisoActual, int pisoDestino) {
        if (pisoDestino < pisoActual || pisoDestino > PISO_MAXIMO) {
            System.out.println("Error: Piso destino inválido para subir.");
            return;
        }
        System.out.println("Piso actual: " + pisoActual);
        cerrarPuerta();
        mover(pisoActual == pisoDestino ? null : pisoActual + 1, pisoDestino, true);
    }

    public void bajar(int pisoActual, int pisoDestino) {
        if (pisoDestino > pisoActual || pisoDestino < PISO_MINIMO) {
            System.out.println("Error: Piso destino inválido para bajar.");
            return;
        }
        System.out.println("Piso actual: " + pisoActual);
        cerrarPuerta();
        mover(pisoActual == pisoDestino ? null : pisoActual - 1, pisoDestino, false);
    }

    private void mover(Integer pisoActual, int pisoDestino, boolean subiendo) {
        if (pisoActual == null) {
            abrirPuerta();
            return;
        }
        System.out.println("Piso actual: " + pisoActual);
        mover(pisoActual == pisoDestino ? null : (subiendo ? pisoActual + 1 : pisoActual - 1), pisoDestino, subiendo);
    }

    private void cerrarPuerta() {
        System.out.println("Cerrando puerta...");
    }

    private void abrirPuerta() {
        System.out.println("Abriendo puerta...");
    }
}
