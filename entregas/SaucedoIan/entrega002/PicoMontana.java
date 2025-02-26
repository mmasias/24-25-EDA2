public class PicoMontana {
    public static int encontrarPico(int[] numeros) {
        int inicio = 0;
        int fin = numeros.length - 1;
        
        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;
            
            if (numeros[medio] > numeros[medio + 1]) {
                fin = medio;
            } else {
                inicio = medio + 1;
            }
        }
        return numeros[inicio];
    }

    private static void mostrarArreglo(int[] arreglo) {
        System.out.print("[");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    private static int[] generarMontana(int tamano) {
        int[] montana = new int[tamano];
        int pico = tamano / 2;
        
        montana[pico] = tamano;
        for (int i = pico - 1; i >= 0; i--) {
            montana[i] = montana[i + 1] - 2;
        }
        for (int i = pico + 1; i < tamano; i++) {
            montana[i] = montana[i - 1] - 2;
        }
        return montana;
    }

    public static void main(String[] args) {
        int[] montanaFija = {1, 3, 5, 7, 6, 4, 2};
        System.out.println("Montaña:");
        mostrarArreglo(montanaFija);
        System.out.println("Pico encontrado: " + encontrarPico(montanaFija));
        
        System.out.println("\nPrueba con montaña generada:");
        int[] montanaGenerada = generarMontana(9);
        mostrarArreglo(montanaGenerada);
        System.out.println("Pico encontrado: " + encontrarPico(montanaGenerada));
    }
}