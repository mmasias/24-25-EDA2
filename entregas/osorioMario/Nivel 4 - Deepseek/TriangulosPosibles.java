public class TriangulosPosibles {
    public static boolean existeTriangulo(int[] numeros) {
        if (numeros.length < 3) return false;
        // Ordenar el array
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }
        // Verificar triángulos
        for (int i = 0; i < numeros.length - 2; i++) {
            if (numeros[i] + numeros[i + 1] > numeros[i + 2]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numeros = {3, 4, 5, 6, 7};
        System.out.println("¿Existe un triángulo? " + existeTriangulo(numeros));
    }
}