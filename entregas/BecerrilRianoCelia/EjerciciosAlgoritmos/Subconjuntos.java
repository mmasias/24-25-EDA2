package EjerciciosAlgoritmos;

public class Subconjuntos {

    public static void encontrarSubconjuntos(int[] numeros) {
        int longitud = numeros.length;
        int totalSubconjuntos = (int) Math.pow(2, longitud);

        for (int subconjuntoActual = 0; subconjuntoActual < totalSubconjuntos; subconjuntoActual++) {
            System.out.print("[");
            for (int indice = 0; indice < longitud; indice++) {
                if ((subconjuntoActual & (1 << indice)) != 0) {
                    System.out.print(numeros[indice] + " ");
                }
            }
            System.out.println("]");
        }
    }

    public static void encontrarSubconjuntosDeTamanoK(int[] numeros, int k) {
        int[] subconjunto = new int[k];
        generarSubconjuntosDeTamanoK(numeros, subconjunto, 0, 0, k);
    }

    private static void generarSubconjuntosDeTamanoK(int[] numeros, int[] subconjunto, int indiceSubconjunto, int inicio, int k) {
        if (indiceSubconjunto == k) {
            System.out.print("[");
            for (int indice = 0; indice < k; indice++) {
                System.out.print(subconjunto[indice] + " ");
            }
            System.out.println("]");
            return;
        }

        for (int indice = inicio; indice < numeros.length; indice++) {
            subconjunto[indiceSubconjunto] = numeros[indice];
            generarSubconjuntosDeTamanoK(numeros, subconjunto, indiceSubconjunto + 1, indice + 1, k);
        }
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3};
        System.out.println("Todos los subconjuntos:");
        encontrarSubconjuntos(numeros);

        int k = 2;
        System.out.println("Subconjuntos de tamaño " + k + ":");
        encontrarSubconjuntosDeTamanoK(numeros, k);
    }
}