package Reto002.Nivel2;

public class ElementoMayoritario {

    public static int primeraOcurrencia(int[] arr, int candidato) {
        int low = 0;
        int high = arr.length - 1;
        int resultado = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == candidato) {
                resultado = mid;
                high = mid - 1; 
            } else if (arr[mid] < candidato) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return resultado;
    }

    public static int ultimaOcurrencia(int[] arr, int candidato) {
        int low = 0;
        int high = arr.length - 1;
        int resultado = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == candidato) {
                resultado = mid;
                low = mid + 1; 
            } else if (arr[mid] < candidato) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return resultado;
    }

    public static int encontrarElementoMayoritario(int[] arr) {
        int n = arr.length;
        int candidato = arr[n / 2];
        
        int primero = primeraOcurrencia(arr, candidato);
        int ultimo = ultimaOcurrencia(arr, candidato);
        
        int ocurrencias = ultimo - primero + 1;
        
        if (ocurrencias > n / 2) {
            return candidato;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 3};
        int mayoritario = encontrarElementoMayoritario(arr);
        System.out.println("Salida: " + mayoritario);
    }
}

