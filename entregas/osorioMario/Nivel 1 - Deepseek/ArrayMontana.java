public class ArrayMontana {
    public static boolean esMontana(int[] numeros) {
        if (numeros.length < 3) return false;
        int i = 0;
        // Fase creciente
        while (i < numeros.length - 1 && numeros[i] < numeros[i + 1]) {
            i++;
        }
        // Verificar si no hay fase decreciente
        if (i == 0 || i == numeros.length - 1) return false;
        // Fase decreciente
        while (i < numeros.length - 1 && numeros[i] > numeros[i + 1]) {
            i++;
        }
        return i == numeros.length - 1;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 4, 2};
        System.out.println("Es montaña: " + esMontana(numeros));
    }
}