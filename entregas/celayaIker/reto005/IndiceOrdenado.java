package entregas.celayaIker.reto005;

public class IndiceOrdenado extends Indice{

    public IndiceOrdenado(int capacidadMaxima) {
        super(capacidadMaxima);
    }

    @Override
    public void agregar(String valor, int posicion) {
        int indiceValor = -1;
        int i = 0;

        while (i < cantidadValores && indiceValor == -1) {
            if (valores[i].equals(valor)) {
                indiceValor = i;
            }
            i++;
        }

        if (indiceValor == -1) {
            valores[cantidadValores] = valor;
            indiceValor = cantidadValores;
            cantidadValores++;
        }

        posiciones[indiceValor][contadores[indiceValor]] = posicion;
        contadores[indiceValor]++;

        ordenar();
    }

    private void ordenar() {
        boolean huboCambio;
        do {
            huboCambio = false;
            for (int i = 0; i < cantidadValores - 1; i++) {
                if (valores[i].compareTo(valores[i + 1]) > 0) {

                    String tempValor = valores[i];
                    valores[i] = valores[i + 1];
                    valores[i + 1] = tempValor;


                    int[] tempPosiciones = posiciones[i];
                    posiciones[i] = posiciones[i + 1];
                    posiciones[i + 1] = tempPosiciones;

                    int tempContador = contadores[i];
                    contadores[i] = contadores[i + 1];
                    contadores[i + 1] = tempContador;

                    huboCambio = true;
                }
            }
        } while (huboCambio);
    }

}