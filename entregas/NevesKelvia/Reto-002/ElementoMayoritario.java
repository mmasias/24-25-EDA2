1public class ElementoMayoritario {
    
    public static int encontrarElementoMayoritario(int[] numeros) {
        int n = numeros.length;
        int mitad = n / 2;
        
        int candidato = numeros[mitad]; 
        
        int primeraAparicion = buscarPrimeraPosicion(numeros, candidato);
        int ultimaAparicion = buscarUltimaPosicion(numeros, candidato);
        
        if (ultimaAparicion - primeraAparicion + 1 > mitad) {
            return candidato;
        }
        return -1; 
    }
    
    private static int buscarPrimeraPosicion(int[] numeros, int objetivo) {
        int izquierda = 0, derecha = numeros.length - 1, resultado = -1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (numeros[medio] >= objetivo) {
                derecha = medio - 1;
                resultado = medio;
            } else {
                izquierda = medio + 1;
            }
        }
        return resultado;
    }
    
    private static int buscarUltimaPosicion(int[] numeros, int objetivo) {
        int izquierda = 0, derecha = numeros.length - 1, resultado = -1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (numeros[medio] <= objetivo) {
                izquierda = medio + 1;
                resultado = medio;
            } else {
                derecha = medio - 1;
            }
        }
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1,1,1,1,2,2,3};
        System.out.println("Elemento mayoritario: " + encontrarElementoMayoritario(numeros));
    }
}
