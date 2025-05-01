package entregas.lopezMartin.reto006;

public class ComparadorTexto implements Comparador {
    @Override
    public int comparar(String valor1, String valor2) {
        return valor1.compareTo(valor2);
    }
}