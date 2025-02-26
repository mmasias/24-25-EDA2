public class Subconjuntos {
// Completado
    public static void main(String[] args) {
        imprimirSubconjuntos();
    }
    public void mostrar(){
        imprimirSubconjuntos();
    }
    public static void imprimirSubconjuntos(){
        int[] conjunto = {1, 2, 3};
        System.out.println("Todos los subconjuntos:");
        subconjuntos(conjunto);
        int k = 2;
        System.out.println("Subconjuntos de tamaño " + k + ":");
        imprimirSubconjuntosDeTamañoK(conjunto, k);
    }

    public static void subconjuntos(int[] conjunto) {
        generarSubconjuntos(conjunto, 0, new int[0]);
    }

    public static void generarSubconjuntos(int[] conjunto, int index, int[] actual) {
        if (index == conjunto.length) {
            System.out.print("[");
            for (int i = 0; i < actual.length; i++) {
                System.out.print(actual[i]);
                if (i < actual.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            return;
        }
        generarSubconjuntos(conjunto, index + 1, actual);
        int[] nuevoActual = new int[actual.length + 1];
        System.arraycopy(actual, 0, nuevoActual, 0, actual.length);
        nuevoActual[actual.length] = conjunto[index];
        generarSubconjuntos(conjunto, index + 1, nuevoActual);
    }

    public static void imprimirSubconjuntosDeTamañoK(int[] conjunto, int k) {
        generarSubconjuntosDeTamañoK(conjunto, 0, new int[0], k);
    }

    public static void generarSubconjuntosDeTamañoK(int[] conjunto, int index, int[] actual, int k) {
        if (actual.length == k) {
            System.out.print("[");
            for (int i = 0; i < actual.length; i++) {
                System.out.print(actual[i]);
                if (i < actual.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            return;
        }
        if (index == conjunto.length) {
            return;
        }
        generarSubconjuntosDeTamañoK(conjunto, index + 1, actual, k);
        int[] nuevoActual = new int[actual.length + 1];
        System.arraycopy(actual, 0, nuevoActual, 0, actual.length);
        nuevoActual[actual.length] = conjunto[index];
        generarSubconjuntosDeTamañoK(conjunto, index + 1, nuevoActual, k);
    }
}