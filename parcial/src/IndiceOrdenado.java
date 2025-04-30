import java.util.Arrays;

public class IndiceOrdenado extends Indice {
    private String[] valores;
    private int[][] posiciones;
    private int[] contadores;
    private int cantidadValores;

    public IndiceOrdenado(int capacidadMaxima) {
        valores = new String[capacidadMaxima];
        posiciones = new int[capacidadMaxima][capacidadMaxima];
        contadores = new int[capacidadMaxima];
        cantidadValores = 0;
    }

    @Override
    public void agregar(String valor, int posicion) {
        int indiceValor = Arrays.binarySearch(valores, 0, cantidadValores, valor);
        
        if (indiceValor < 0) {
            indiceValor = -(indiceValor + 1);
            System.arraycopy(valores, indiceValor, valores, indiceValor + 1, cantidadValores - indiceValor);
            System.arraycopy(contadores, indiceValor, contadores, indiceValor + 1, cantidadValores - indiceValor);
            for (int i = 0; i < contadores[indiceValor]; i++) {
                System.arraycopy(posiciones[indiceValor], 0, posiciones[indiceValor + 1], 0, contadores[indiceValor]);
            }
            valores[indiceValor] = valor;
            contadores[indiceValor] = 0;
            cantidadValores++;
        }

        posiciones[indiceValor][contadores[indiceValor]] = posicion;
        contadores[indiceValor]++;
    }

    @Override
    public int[] buscar(String valor) {
        int indiceValor = Arrays.binarySearch(valores, 0, cantidadValores, valor);
        if (indiceValor < 0) {
            return new int[0];
        }

        int[] resultado = new int[contadores[indiceValor]];
        System.arraycopy(posiciones[indiceValor], 0, resultado, 0, contadores[indiceValor]);
        return resultado;
    }

    @Override
    public String[] obtenerTodos() {
        String[] resultado = new String[cantidadValores];
        System.arraycopy(valores, 0, resultado, 0, cantidadValores);
        return resultado;
    }
}
