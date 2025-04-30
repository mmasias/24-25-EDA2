import java.util.ArrayList;

public class IndiceNoOrdenado extends Indice {
    private ArrayList<String> valores;
    private ArrayList<ArrayList<Integer>> posiciones;

    public IndiceNoOrdenado() {
        valores = new ArrayList<>();
        posiciones = new ArrayList<>();
    }

    @Override
    public void agregar(String valor, int posicion) {
        int indiceValor = valores.indexOf(valor);
        
        if (indiceValor == -1) {
            valores.add(valor);
            ArrayList<Integer> listaPosiciones = new ArrayList<>();
            listaPosiciones.add(posicion);
            posiciones.add(listaPosiciones);
        } else {
            posiciones.get(indiceValor).add(posicion);
        }
    }

    @Override
    public int[] buscar(String valor) {
        int indiceValor = valores.indexOf(valor);
        
        if (indiceValor == -1) {
            return new int[0];
        }

        ArrayList<Integer> listaPosiciones = posiciones.get(indiceValor);
        int[] resultado = new int[listaPosiciones.size()];
        for (int i = 0; i < listaPosiciones.size(); i++) {
            resultado[i] = listaPosiciones.get(i);
        }
        return resultado;
    }

    @Override
    public String[] obtenerTodos() {
        return valores.toArray(new String[0]);
    }
}
