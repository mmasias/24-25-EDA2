package Nivel2;

public class PicoMontana {
    public static int encontrarPicoMontana(int[] numeros) {
        int inicio = 0;
        int fin = numeros.length - 1;
        
        while (inicio < fin) {
            int medio = (inicio + fin) / 2;
            if (numeros[medio] > numeros[medio + 1]) {
                fin = medio;
            } else {
                inicio = medio + 1;
            }
        }
        
        return numeros[inicio]; 
    }

    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 7, 6, 4, 2};
        int pico = encontrarPicoMontana(numeros);
        System.out.println("Pico de montaña: " + pico);
    }
}
