public class ElementoMayoritario {
    public static int encontrarElementoMayoritario(int[] numeros) {
        int candidato = numeros[0];
        int contador = 1;
        
        for (int i = 1; i < numeros.length; i++) {
            if (contador == 0) {
                candidato = numeros[i];
                contador = 1;
            } else if (numeros[i] == candidato) {
                contador++;
            } else {
                contador--;
            }
        }
        
        contador = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == candidato) {
                contador++;
            }
        }
        
        if (contador > numeros.length / 2) {
            return candidato;
        }
        
        return -1; 
    }
    
    public static int encontrarElementoMayoritarioOrdenado(int[] numeros) {
        int n = numeros.length;
        int candidato = numeros[n / 2]; 
        
        int primeraPosicion = busquedaBinariaPrimera(numeros, candidato);
        int ultimaPosicion = busquedaBinariaUltima(numeros, candidato);
        
        int frecuencia = ultimaPosicion - primeraPosicion + 1;
        
        if (frecuencia > n / 2) {
            return candidato;
        }
        
        return -1; 
    }
    
    private static int busquedaBinariaPrimera(int[] numeros, int objetivo) {
        int izquierda = 0;
        int derecha = numeros.length - 1;
        int resultado = -1;
        
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            if (numeros[medio] == objetivo) {
                resultado = medio;
                derecha = medio - 1; 
            } else if (numeros[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        
        return resultado;
    }
    
    private static int busquedaBinariaUltima(int[] numeros, int objetivo) {
        int izquierda = 0;
        int derecha = numeros.length - 1;
        int resultado = -1;
        
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            if (numeros[medio] == objetivo) {
                resultado = medio;
                izquierda = medio + 1; 
            } else if (numeros[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 1, 1, 1, 2, 2, 3};
        
        int mayoritario1 = encontrarElementoMayoritario(numeros);
        int mayoritario2 = encontrarElementoMayoritarioOrdenado(numeros);
        
        System.out.println("Elemento mayoritario (método lineal): " + mayoritario1);
        System.out.println("Elemento mayoritario (método logarítmico): " + mayoritario2);
    }
}