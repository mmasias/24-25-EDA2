package entregas.martinezDiego.nivel4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletesSumaCero {
    public static List<List<Integer>> encontrarTripletesSumaCero(int[] numeros) {
        Arrays.sort(numeros);
        List<List<Integer>> resultado = new ArrayList<>();

        for (int i = 0; i < numeros.length - 2; i++) {
            if (i > 0 && numeros[i] == numeros[i - 1]) {
                continue; 
            }
            
            int izquierda = i + 1;
            int derecha = numeros.length - 1;

            while (izquierda < derecha) {
                int suma = numeros[i] + numeros[izquierda] + numeros[derecha];

                if (suma == 0) {
                    resultado.add(Arrays.asList(numeros[i], numeros[izquierda], numeros[derecha]));
                    while (izquierda < derecha && numeros[izquierda] == numeros[izquierda + 1]) {
                        izquierda++;
                    }
                    while (izquierda < derecha && numeros[derecha] == numeros[derecha - 1]) {
                        derecha--;
                    }
                    izquierda++;
                    derecha--;
                } else if (suma < 0) {
                    izquierda++;
                } else {
                    derecha--;
                }
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] numeros = {-1, 0, 1, 2, -1, -4};

        System.out.print("Entrada: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        List<List<Integer>> resultado = encontrarTripletesSumaCero(numeros);
        System.out.println("Salida: " + resultado);
    }
}

