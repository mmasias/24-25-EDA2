package entregas.lopezMartin.reto006;

public class Indice {
    private String[] valores;
    private int[][] posiciones;
    private int[] contadores;
    private int cantidadValores;
    private Comparador comparador;

    public Indice(int capacidadMaxima, Comparador comparador) {
        valores = new String[capacidadMaxima];
        posiciones = new int[capacidadMaxima][capacidadMaxima];
        contadores = new int[capacidadMaxima];
        cantidadValores = 0;
        this.comparador = comparador;
    }

    public void agregar(String valor, int posicion) {
        int indiceValor = buscarPosicionOrdenada(valor);
        
        if (indiceValor < 0) {
            indiceValor = -(indiceValor + 1);
            
            for (int i = cantidadValores; i > indiceValor; i--) {
                valores[i] = valores[i-1];
                contadores[i] = contadores[i-1];
                for (int j = 0; j < contadores[i-1]; j++) {
                    posiciones[i][j] = posiciones[i-1][j];
                }
            }
            valores[indiceValor] = valor;
            contadores[indiceValor] = 0;
            cantidadValores++;
        }
        posiciones[indiceValor][contadores[indiceValor]] = posicion;
        contadores[indiceValor]++;
    }

    private int buscarPosicionOrdenada(String valor) {
        int inicio = 0;
        int fin = cantidadValores - 1;
        
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = comparador.comparar(valores[medio], valor);
            
            if (comparacion < 0) {
                inicio = medio + 1;
            } else if (comparacion > 0) {
                fin = medio - 1;
            } else {
                return medio;
            }
        }
        return -(inicio + 1);
    }

    public int[] buscar(String valor) {
        int indiceValor = buscarPosicionOrdenada(valor);
        if (indiceValor < 0) {
            return new int[0];
        }

        int[] resultado = new int[contadores[indiceValor]];
        for (int i = 0; i < contadores[indiceValor]; i++) {
            resultado[i] = posiciones[indiceValor][i];
        }

        return resultado;
    }

    public boolean contiene(String valor) {
        return buscarPosicionOrdenada(valor) >= 0;
    }

    public String[] obtenerTodos() {
        String[] resultado = new String[cantidadValores];
        for (int i = 0; i < cantidadValores; i++) {
            resultado[i] = valores[i];
        }
        return resultado;
    }

    public void imprimirEstado() {
        System.out.println("Estado actual del índice:");
        for (int i = 0; i < cantidadValores; i++) {
            System.out.printf("Valor: %-20s | Posiciones: ", valores[i]);
            for (int j = 0; j < contadores[i]; j++) {
                System.out.print(posiciones[i][j] + " ");
            }
            System.out.println();
        }
    }
}