package entregas.lopezMartin.reto006;

public class ComparadorNumerico implements Comparador {
    @Override
    public int comparar(String valor1, String valor2) {
        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);
        return Integer.compare(num1, num2);
    }
}