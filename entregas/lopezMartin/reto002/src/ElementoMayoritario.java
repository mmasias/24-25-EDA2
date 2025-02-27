package entregas.lopezMartin.reto002.src;

public class ElementoMayoritario {
    
    public static int encontrarElementoMayoritario1(int[] arr) {
        int n = arr.length;
        int candidato = arr[n / 2]; 
        
        int contador = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == candidato) {
                contador++;
            }
        }
        
        if (contador > n / 2) {
            return candidato;
        } else {
            return -1;
        }
    }

    public static int encontrarElementoMayoritario2(int[] arr) {
        int n = arr.length;
        int elementoActual = arr[0];
        int contador = 1;
        int maxFrecuencia = 1;
        int elementoMayor = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] == elementoActual) {
                contador++;
            } else {
                elementoActual = arr[i];
                contador = 1;
            }

            if (contador > maxFrecuencia) {
                maxFrecuencia = contador;
                elementoMayor = arr[i];
            }
        }

        return maxFrecuencia > n / 2 ? elementoMayor : -1;
    }

    
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 3};
        int resultado = encontrarElementoMayoritario2(arr);
        System.out.println("Elemento mayoritario: " + resultado);
    }

}
