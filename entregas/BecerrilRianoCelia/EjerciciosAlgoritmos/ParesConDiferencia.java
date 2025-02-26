package EjerciciosAlgoritmos;

public class ParesConDiferencia {

    public static void encontrarParesConDiferencia(int[] arr, int[] diferencias) {
        int longitud = arr.length;

        for (int diferencia : diferencias) {
            boolean encontrado = false;
            System.out.println("Buscando pares con diferencia " + diferencia + ":");

            for (int indice = 0; indice < longitud; indice++) {
                for (int indiceComparacion = indice + 1; indiceComparacion < longitud; indiceComparacion++) {
                    if (Math.abs(arr[indice] - arr[indiceComparacion]) == diferencia) {
                        System.out.println("Par encontrado: (" + arr[indice] + ", " + arr[indiceComparacion] + ")");
                        encontrado = true;
                    }
                }
            }

            if (!encontrado) {
                System.out.println("No se encontraron pares con diferencia " + diferencia);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9, 2, 12, 3};
        int[] diferencias = {2, 4};
        encontrarParesConDiferencia(arr, diferencias);
    }
}