public class ElementoMayoritario {
    public static int encontrarElementoMayoritario(int[] numeros) {
        int n = numeros.length;
        int candidato = numeros[n / 2];
        
        int primeraPos = buscarPrimeraPosicion(numeros, candidato);
        int ultimaPos = buscarUltimaPosicion(numeros, candidato);
        
        if (ultimaPos - primeraPos + 1 > n / 2) {
            return candidato;
        }
        return -1;
    }
    
    private static int buscarPrimeraPosicion(int[] numeros, int objetivo) {
        int inicio = 0, fin = numeros.length - 1;
        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (numeros[medio] < objetivo) {
                inicio = medio + 1;
            } else {
                fin = medio;
            }
        }
        return inicio;
    }
    
    private static int buscarUltimaPosicion(int[] numeros, int objetivo) {
        int inicio = 0, fin = numeros.length - 1;
        while (inicio < fin) {
            int medio = inicio + (fin - inicio + 1) / 2;
            if (numeros[medio] > objetivo) {
                fin = medio - 1;
            } else {
                inicio = medio;
            }
        }
        return inicio;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 1, 1, 1, 2, 2, 3};
        System.out.println("Elemento mayoritario: " + encontrarElementoMayoritario(numeros));
    }
}