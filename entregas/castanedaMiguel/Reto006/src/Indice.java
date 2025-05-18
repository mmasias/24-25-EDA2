public class Indice {
    //Posibles valores en indice
    private String[] valores;
    //Posicion en la que esta? nose
    private int[][] posiciones;
    //numero veces que sale valor
    private int[] contadores;
    //cantidad total de valores distintos
    private int cantidadValores;

    public Indice(int capacidadMaxima) {
        valores = new String[capacidadMaxima];
        posiciones = new int[capacidadMaxima][capacidadMaxima];
        contadores = new int[capacidadMaxima];
        cantidadValores = 0;
    }

    public void agregar(String valor, int posicion) { //valor segun qué indice????
        int indiceValor = -1;
        int i = 0;

        while (i < cantidadValores && indiceValor == -1) {
            if (valores[i].equals(valor)) {
                indiceValor = i;
            }
            i++;
        }

        if (indiceValor == -1) {//por si el valor es distinto al resto
            valores[cantidadValores] = valor;
            indiceValor = cantidadValores;
            cantidadValores++;
        }

        posiciones[indiceValor][contadores[indiceValor]] = posicion;
        contadores[indiceValor]++;
    }

   /* public void agregar2(String valor,int posicion){
        int indiceValor=buscar(valor);

    }*/

    public int[] buscar(String valor) {
        int indiceValor = -1;
        int posicion = 0;

        while (posicion < cantidadValores && indiceValor == -1) {
            if (valores[posicion].equals(valor)) {
                indiceValor = posicion;
            }
            posicion++;
        }

        if (indiceValor == -1) {
            return new int[0];
        }

        int[] resultado = new int[contadores[indiceValor]];
        for (int i = 0; i < contadores[indiceValor]; i++) {
            resultado[i] = posiciones[indiceValor][i];
        }

        return resultado;
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