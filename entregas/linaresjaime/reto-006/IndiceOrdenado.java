public class IndiceOrdenado extends Indice {
    private boolean descendente;
    private boolean esNumerico;

    public IndiceOrdenado(int capacidadMaxima, AlgoritmoOrdenacion algoritmoOrdenacion, boolean descendente) {
        super(capacidadMaxima, algoritmoOrdenacion);
        this.descendente = descendente;
        this.esNumerico = true;
    }

    public void setEsNumerico(boolean esNumerico) {
        this.esNumerico = esNumerico;
    }

    public boolean esNumerico() {
        return esNumerico;
    }

    @Override
    public int[] buscar(String valor) {
        if (esNumerico) {
            try {
                int numValor = Integer.parseInt(valor);
                return buscarNumerico(numValor);
            } catch (NumberFormatException e) {
                return super.buscar(valor);
            }
        }
        return super.buscar(valor);
    }

    private int[] buscarNumerico(int valor) {
        for (int i = 0; i < getCantidadValores(); i++) {
            try {
                int current = Integer.parseInt(getValor(i));
                if (current == valor) {
                    return buscarPorIndice(i);
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }
        return new int[0];
    }
}