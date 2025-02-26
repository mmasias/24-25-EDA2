package Nivel2;

public class ElementoUnico {
    public static int encontrarElementoUnico(int[] numeros) {
        int unico = 0;
        for (int num : numeros) {
            unico ^= num; 
        }
        return unico;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 1, 3, 2};
        int unico = encontrarElementoUnico(numeros);
        System.out.println("Elemento único: " + unico);
    }
}

