package v000;

public class IndiceOrdenado extends Indice {
    private String[] valoresOrdenados;
    private int[][] posicionesOrdenadas;
    private int[] contadoresOrdenados;
    private int cantidadValoresOrdenados;

    public IndiceOrdenado(int capacidadMaxima) {
        super(capacidadMaxima);
        valoresOrdenados = new String[capacidadMaxima];
        posicionesOrdenadas = new int[capacidadMaxima][capacidadMaxima];
        contadoresOrdenados = new int[capacidadMaxima];
        cantidadValoresOrdenados = 0;
    }

    @Override
    public void agregar(String valor, int posicion) {
        int index = busquedaBinaria(valor);

        if (index >= 0) {
            posicionesOrdenadas[index][contadoresOrdenados[index]] = posicion;
            contadoresOrdenados[index]++;
        } else {
            int insertarEn = -index - 1;
            for (int i = cantidadValoresOrdenados; i > insertarEn; i--) {
                valoresOrdenados[i] = valoresOrdenados[i - 1];
                posicionesOrdenadas[i] = posicionesOrdenadas[i - 1];
                contadoresOrdenados[i] = contadoresOrdenados[i - 1];
            }
            valoresOrdenados[insertarEn] = valor;
            posicionesOrdenadas[insertarEn] = new int[posicionesOrdenadas.length];
            posicionesOrdenadas[insertarEn][0] = posicion;
            contadoresOrdenados[insertarEn] = 1;
            cantidadValoresOrdenados++;
        }
    }

    @Override
    public int[] buscar(String valor) {
        int index = busquedaBinaria(valor);

        if (index >= 0) {
            int[] resultado = new int[contadoresOrdenados[index]];
            for (int i = 0; i < contadoresOrdenados[index]; i++) {
                resultado[i] = posicionesOrdenadas[index][i];
            }
            return resultado;
        }
        return new int[0];
    }

    @Override
    public String[] obtenerTodos() {
        String[] resultado = new String[cantidadValoresOrdenados];
        for (int i = 0; i < cantidadValoresOrdenados; i++) {
            resultado[i] = valoresOrdenados[i];
        }
        return resultado;
    }

    private int busquedaBinaria(String valor) {
        int izquierda = 0;
        int derecha = cantidadValoresOrdenados - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int comparacion = valoresOrdenados[medio].compareTo(valor);

            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -(izquierda + 1);
    }
}
