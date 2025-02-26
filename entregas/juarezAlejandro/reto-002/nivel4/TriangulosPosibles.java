package nivel4;

public class TriangulosPosibles {
    public static void main(String[] args) {
        int[] entrada = { 3, 4, 5, 6, 7 };
        boolean encontrado = false;

        for (int i = 0; i < entrada.length - 2; i++) {
            for (int j = i + 1; j < entrada.length - 1; j++) {
                for (int k = j + 1; k < entrada.length; k++) {
                    if (esTriangulo(entrada[i], entrada[j], entrada[k])) {
                        System.out.println("true (" + entrada[i] + "," + entrada[j] + "," + entrada[k] + ")");
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado)
                    break;
            }
            if (encontrado)
                break;
        }

        if (!encontrado) {
            System.out.println("false");
        }
    }

    public static boolean esTriangulo(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
