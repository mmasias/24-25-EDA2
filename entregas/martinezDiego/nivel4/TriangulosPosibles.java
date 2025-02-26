package entregas.martinezDiego.nivel4;


public class TriangulosPosibles {
    public static boolean puedeFormarTriangulo(int[] numeros) {
        for (int i = 0; i < numeros.length - 2; i++) {
            for (int j = i + 1; j < numeros.length - 1; j++) {
                for (int k = j + 1; k < numeros.length; k++) {
                    if (numeros[i] + numeros[j] > numeros[k] &&
                        numeros[i] + numeros[k] > numeros[j] &&
                        numeros[j] + numeros[k] > numeros[i]) {
                        System.out.println("Salida: true (" + numeros[i] + "," + numeros[j] + "," + numeros[k] + ")");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numeros = {3, 4, 5, 6, 7};

        System.out.print("Entrada: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        if (!puedeFormarTriangulo(numeros)) {
            System.out.println("Salida: false");
        }
    }
}

