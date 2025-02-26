public class SumaObjetivo {
    public static int[] twoSum(int[] numeros, int target) {
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] + numeros[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        throw new IllegalArgumentException("No se encontró ninguna solución");
    }

    public static void main(String[] args) {
        int[] numeros = {3, 2, 9, 8};
        int target = 10;
        int[] resultado = twoSum(numeros, target);
        
        System.out.println("Índices: [" + resultado[0] + ", " + resultado[1] + "]");
    }
}