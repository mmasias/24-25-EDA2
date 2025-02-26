package entregas.martinezDiego.nivel1;

public class Montaña {
    public static boolean esMontaña(int[] numeros) {
        int n = numeros.length;
        if (n < 3) {
            return false;
        }

        int i = 0;

        while (i + 1 < n && numeros[i] < numeros[i + 1]) {
            i++;
        }

        if (i == 0 || i == n - 1) {
            return false;
        }

        while (i + 1 < n && numeros[i] > numeros[i + 1]) {
            i++;
        }

        return i == n - 1;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 3, 6, 4, 2};

        System.out.print("Entrada: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        boolean resultado = esMontaña(numeros);
        System.out.println("Salida: " + resultado);
    }
}
