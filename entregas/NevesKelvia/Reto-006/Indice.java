public class Indice {
    private String[] valores;
    private int[][] posiciones;
    private int[] contadores;
    private int cantidadValores;

    public Indice(int capacidadMaxima) {
        valores = new String[capacidadMaxima];
        posiciones = new int[capacidadMaxima][capacidadMaxima];
        contadores = new int[capacidadMaxima];
        cantidadValores = 0;
    }

    public void agregar(String valor, int posicion) {
        int indiceValor = -1;

        for (int i = 0; i < cantidadValores; i++) {
            if (valores[i].equals(valor)) {
                indiceValor = i;
                break;
            }
        }

        if (indiceValor == -1) {
            int i = cantidadValores - 1;
            while (i >= 0 && valores[i].compareTo(valor) > 0) {
                valores[i + 1] = valores[i];
                posiciones[i + 1] = posiciones[i];
                contadores[i + 1] = contadores[i];
                i--;
            }

            indiceValor = i + 1;
            valores[indiceValor] = valor;
            posiciones[indiceValor] = new int[posiciones[0].length];
            contadores[indiceValor] = 0;
            cantidadValores++;
        }

        posiciones[indiceValor][contadores[indiceValor]] = posicion;
        contadores[indiceValor]++;
    }

    public int[] buscar(String valor) {
        for (int i = 0; i < cantidadValores; i++) {
            if (valores[i].equals(valor)) {
                int[] resultado = new int[contadores[i]];
                for (int j = 0; j < contadores[i]; j++) {
                    resultado[j] = posiciones[i][j];
                }
                return resultado;
            }
        }
        return new int[0];
    }

    public boolean contiene(String valor) {
        for (int i = 0; i < cantidadValores; i++) {
            if (valores[i].equals(valor)) {
                return true;
            }
        }
        return false;
    }

    public String[] obtenerTodos() {
        String[] resultado = new String[cantidadValores];
        for (int i = 0; i < cantidadValores; i++) {
            resultado[i] = valores[i];
        }
        return resultado;
    }
}
