public class ElementoMayoritario {
    public static int encontrarElementoMayoritario(int[] numeros) {
        int n = numeros.length;
        int candidato = numeros[n / 2];
        int primero = buscarPrimeraOcurrencia(numeros, candidato);
        int ultimo = buscarUltimaOcurrencia(numeros, candidato);
        
        if (ultimo - primero + 1 > n / 2) {
            return candidato;
        }
        return -1;
    }

    private static int buscarPrimeraOcurrencia(int[] numeros, int target) {
        int izquierda = 0, derecha = numeros.length - 1;
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (numeros[medio] < target) {
                izquierda = medio + 1;
            } else {
                derecha = medio;
            }
        }
        return izquierda;
    }

    private static int buscarUltimaOcurrencia(int[] numeros, int target) {
        int izquierda = 0, derecha = numeros.length - 1;
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda + 1) / 2;
            if (numeros[medio] > target) {
                derecha = medio - 1;
            } else {
                izquierda = medio;
            }
        }
        return izquierda;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 1, 1, 1, 2, 2, 3};
        System.out.println(encontrarElementoMayoritario(numeros));
    }
}