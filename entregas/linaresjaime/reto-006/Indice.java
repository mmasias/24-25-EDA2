
public class Indice {
    private String[] valores;
    private int[][] posiciones;
    private int[] contadores;
    private int cantidadValores;
    private AlgoritmoOrdenacion algoritmoOrdenacion;

    public Indice(int capacidadMaxima) {
        this(capacidadMaxima, new QuickSort());
    }

    public Indice(int capacidadMaxima, AlgoritmoOrdenacion algoritmoOrdenacion) {
        valores = new String[capacidadMaxima];
        posiciones = new int[capacidadMaxima][capacidadMaxima];
        contadores = new int[capacidadMaxima];
        cantidadValores = 0;
        this.algoritmoOrdenacion = algoritmoOrdenacion;
    }

    public void setAlgoritmoOrdenacion(AlgoritmoOrdenacion algoritmoOrdenacion) {
        this.algoritmoOrdenacion = algoritmoOrdenacion;
    }

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

            ordenar();
        }
        posiciones[indiceValor][contadores[indiceValor]] = posicion;
        contadores[indiceValor]++;
    }

    protected void ordenar() {
        if (algoritmoOrdenacion != null && cantidadValores > 1) {
            algoritmoOrdenacion.ordenar(valores, posiciones, contadores, cantidadValores);
        }
    }

    public int[] buscar(String valor) {

        for (int i = 0; i < cantidadValores; i++) {
            if (valores[i].equals(valor)) {
                return buscarPorIndice(i);
            }
        }

        return new int[0];
    }

    protected int[] buscarPorIndice(int indiceValor) {
        int[] resultado = new int[contadores[indiceValor]];
        for (int i = 0; i < contadores[indiceValor]; i++) {
            resultado[i] = posiciones[indiceValor][i];
        }
        return resultado;
    }

    private int busquedaBinaria(String valor) {
        int inicio = 0;
        int fin = cantidadValores - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = valores[medio].compareTo(valor);

            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        for (int i = Math.max(0, inicio - 2); i <= Math.min(cantidadValores - 1, inicio + 2); i++) {
            if (valores[i].equals(valor)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contiene(String valor) {
        return busquedaBinaria(valor) != -1;
    }

    public String[] obtenerTodos() {
        String[] resultado = new String[cantidadValores];
        for (int i = 0; i < cantidadValores; i++) {
            resultado[i] = valores[i];
        }
        return resultado;
    }

    protected int getCantidadValores() {
        return cantidadValores;
    }

    protected String getValor(int indice) {
        return valores[indice];
    }

    protected void setValor(int indice, String valor) {
        valores[indice] = valor;
    }

    protected int[] getPosiciones(int indice) {
        return posiciones[indice];
    }

    protected void setPosiciones(int indice, int[] nuevasPosiciones) {
        posiciones[indice] = nuevasPosiciones;
    }

    protected int getContador(int indice) {
        return contadores[indice];
    }

    protected void setContador(int indice, int contador) {
        contadores[indice] = contador;
    }
}