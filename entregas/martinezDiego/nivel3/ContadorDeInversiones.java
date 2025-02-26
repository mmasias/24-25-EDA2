package entregas.martinezDiego.nivel3;

public class ContadorDeInversiones {
    public static int contarInversiones(int[] numeros) {
        return contarInversionesRecursivo(numeros, 0, numeros.length - 1);
    }

    private static int contarInversionesRecursivo(int[] numeros, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            return 0;
        }

        int medio = (izquierda + derecha) / 2;
        int inversionesIzquierda = contarInversionesRecursivo(numeros, izquierda, medio);
        int inversionesDerecha = contarInversionesRecursivo(numeros, medio + 1, derecha);
        int inversionesFusion = contarInversionesDuranteFusion(numeros, izquierda, medio, derecha);

        return inversionesIzquierda + inversionesDerecha + inversionesFusion;
    }

    private static int contarInversionesDuranteFusion(int[] numeros, int izquierda, int medio, int derecha) {
        int[] temp = new int[derecha - izquierda + 1];
        int i = izquierda, j = medio + 1, k = 0;
        int inversiones = 0;

        while (i <= medio && j <= derecha) {
            if (numeros[i] <= numeros[j]) {
                temp[k++] = numeros[i++];
            } else {
                temp[k++] = numeros[j++];
                inversiones += (medio - i + 1); 
            }
        }

        while (i <= medio) {
            temp[k++] = numeros[i++];
        }

        while (j <= derecha) {
            temp[k++] = numeros[j++];
        }

        for (int m = 0; m < temp.length; m++) {
            numeros[izquierda + m] = temp[m];
        }

        return inversiones;
    }

    public static void main(String[] args) {
        int[] numeros = {2, 4, 1, 3, 5};

        System.out.print("Entrada: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int resultado = contarInversiones(numeros);
        System.out.println("Salida: " + resultado);
    }
}

