public class TriangulosPosibles {
    public static boolean existeTriangulo(int[] numeros) {
        // Un triángulo existe si la suma de dos lados es mayor que el tercer lado (para todas las combinaciones)
        for (int i = 0; i < numeros.length - 2; i++) {
            for (int j = i + 1; j < numeros.length - 1; j++) {
                for (int k = j + 1; k < numeros.length; k++) {
                    if (esTriangulo(numeros[i], numeros[j], numeros[k])) {
                        System.out.println("Triángulo encontrado: " + numeros[i] + ", " + numeros[j] + ", " + numeros[k]);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    // Reto adicional: encontrar todos los triángulos posibles
    public static int[][] todosLosTriangulos(int[] numeros) {
        // Primero contamos cuántos triángulos posibles hay
        int count = 0;
        for (int i = 0; i < numeros.length - 2; i++) {
            for (int j = i + 1; j < numeros.length - 1; j++) {
                for (int k = j + 1; k < numeros.length; k++) {
                    if (esTriangulo(numeros[i], numeros[j], numeros[k])) {
                        count++;
                    }
                }
            }
        }
        
        // Crear array para almacenar todos los triángulos
        int[][] triangulos = new int[count][3];
        int index = 0;
        
        // Llenar el array con los triángulos encontrados
        for (int i = 0; i < numeros.length - 2; i++) {
            for (int j = i + 1; j < numeros.length - 1; j++) {
                for (int k = j + 1; k < numeros.length; k++) {
                    if (esTriangulo(numeros[i], numeros[j], numeros[k])) {
                        triangulos[index][0] = numeros[i];
                        triangulos[index][1] = numeros[j];
                        triangulos[index][2] = numeros[k];
                        index++;
                    }
                }
            }
        }
        
        return triangulos;
    }
    
    private static boolean esTriangulo(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }
    
    public static void main(String[] args) {
        int[] entrada = {3, 4, 5, 6, 7};
        
        // Verificar si existe al menos un triángulo
        boolean existeTriangulo = existeTriangulo(entrada);
        System.out.println("¿Existe un triángulo? " + existeTriangulo);
        
        // Encontrar todos los triángulos posibles
        System.out.println("\nTodos los triángulos posibles:");
        int[][] triangulos = todosLosTriangulos(entrada);
        for (int i = 0; i < triangulos.length; i++) {
            System.out.println(triangulos[i][0] + ", " + triangulos[i][1] + ", " + triangulos[i][2]);
        }
    }
}
