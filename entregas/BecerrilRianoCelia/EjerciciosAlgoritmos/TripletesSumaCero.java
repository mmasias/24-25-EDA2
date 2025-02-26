package EjerciciosAlgoritmos;

public class TripletesSumaCero {

    public static void encontrarTripletes(int[] numeros) {
        int longitud = numeros.length;
        boolean encontrado = false;

        
        for (int indiceOrdenamiento = 0; indiceOrdenamiento < longitud - 1; indiceOrdenamiento++) {
            for (int indiceComparacion = 0; indiceComparacion < longitud - indiceOrdenamiento - 1; indiceComparacion++) {
                if (numeros[indiceComparacion] > numeros[indiceComparacion + 1]) {
                    int temp = numeros[indiceComparacion];
                    numeros[indiceComparacion] = numeros[indiceComparacion + 1];
                    numeros[indiceComparacion + 1] = temp;
                }
            }
        }

        
        for (int indice = 0; indice < longitud - 2; indice++) {
            if (indice > 0 && numeros[indice] == numeros[indice - 1]) {
                continue;
            }

            int izquierda = indice + 1;
            int derecha = longitud - 1;

            while (izquierda < derecha) {
                int suma = numeros[indice] + numeros[izquierda] + numeros[derecha];

                if (suma == 0) {
                    System.out.println("Triplete encontrado: (" + numeros[indice] + ", " + numeros[izquierda] + ", " + numeros[derecha] + ")");
                    encontrado = true;

                
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

        if (!encontrado) {
            System.out.println("No se encontraron tripletes que sumen a cero.");
        }
    }

    public static void main(String[] args) {
        int[] numeros = {-1, 0, 1, 2, -1, -4};
        encontrarTripletes(numeros);
    }
}