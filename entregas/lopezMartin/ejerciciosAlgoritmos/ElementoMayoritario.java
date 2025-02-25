package entregas.lopezMartin.ejerciciosAlgoritmos;

public class ElementoMayoritario {
    
    public static int encontrarElementoMayoritario(int[] arr) {
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
    
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 3};
        int resultado = encontrarElementoMayoritario(arr);
        System.out.println("Elemento mayoritario: " + resultado);
    }

}
