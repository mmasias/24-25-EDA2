package nivel2;

public class ElementoMayoritario {
    public static void main(String[] args) {
        int[] entrada = { 1, 1, 1, 1, 2, 2, 3 };
        int n = entrada.length;
        int contador = 1;
        int elementoMayoritario = entrada[0];

        for (int i = 1; i < n; i++) {
            if (entrada[i] == entrada[i - 1]) {
                contador++;
                if (contador > n / 2) {
                    elementoMayoritario = entrada[i];
                    break;
                }
            } else {
                contador = 1;
            }
        }

        System.out.println("El elemento mayoritario es: " + elementoMayoritario);
    }
}
