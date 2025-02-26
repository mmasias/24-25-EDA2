class TripletesSumaCero {
    public static void encontrarTripletes(int[] numeros) {
        int tamano = numeros.length;

        for (int i = 0; i < tamano - 1; i++) {
            for (int j = 0; j < tamano - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temporal = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temporal;
                }
            }
        }

        for (int indice = 0; indice < tamano - 2; indice++) {
            if (indice > 0 && numeros[indice] == numeros[indice - 1]) {
                continue;
            }
            int izquierda = indice + 1, derecha = tamano - 1;
            while (izquierda < derecha) {
                int sumaActual = numeros[indice] + numeros[izquierda] + numeros[derecha];
                if (sumaActual == 0) {
                    System.out.println("[" + numeros[indice] + ", " + numeros[izquierda] + ", " + numeros[derecha] + "]");
                    izquierda++;
                    derecha--;

                    while (izquierda < derecha && numeros[izquierda] == numeros[izquierda - 1]) {
                        izquierda++;
                    }
                    while (izquierda < derecha && numeros[derecha] == numeros[derecha + 1]) {
                        derecha--;
                    }
                } else if (sumaActual < 0) {
                    izquierda++;
                } else {
                    derecha--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numeros = {-1, 0, 1, 2, -1, -4};
        encontrarTripletes(numeros);
    }
}
