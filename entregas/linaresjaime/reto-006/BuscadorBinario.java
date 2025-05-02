import java.util.ArrayList;
import java.util.List;

public class BuscadorBinario {
    private IndiceOrdenado indice;

    public BuscadorBinario(IndiceOrdenado indice) {
        this.indice = indice;
    }

    public int[] buscarRango(String valorInicial, String valorFinal) {
        if (indice.esNumerico()) {
            try {
                int init = Integer.parseInt(valorInicial);
                int end = Integer.parseInt(valorFinal);
                return buscarRangoNumerico(init, end);
            } catch (NumberFormatException e) {
                System.out.println("Error: Los valores de rango deben ser numéricos para esta columna");
                return new int[0];
            }
        }
        return buscarRangoTexto(valorInicial, valorFinal);
    }

    private int[] buscarRangoNumerico(int valorInicial, int valorFinal) {
        List<Integer> resultados = new ArrayList<>();

        for (int i = 0; i < indice.getCantidadValores(); i++) {
            try {
                int current = Integer.parseInt(indice.getValor(i));
                if (current >= valorInicial && current <= valorFinal) {
                    int[] posiciones = indice.buscarPorIndice(i);
                    for (int pos : posiciones) {
                        resultados.add(pos);
                    }
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }

        return resultados.stream().mapToInt(i -> i).toArray();
    }

    private int[] buscarRangoTexto(String valorInicial, String valorFinal) {
        List<Integer> resultados = new ArrayList<>();

        for (int i = 0; i < indice.getCantidadValores(); i++) {
            String current = indice.getValor(i);
            if (current.compareTo(valorInicial) >= 0 && current.compareTo(valorFinal) <= 0) {
                int[] posiciones = indice.buscarPorIndice(i);
                for (int pos : posiciones) {
                    resultados.add(pos);
                }
            }
        }

        return resultados.stream().mapToInt(i -> i).toArray();
    }
}