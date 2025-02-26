package entregas.Reyes_David.Reto_002.Nivel2;

public class ElementoUnico {
    public static int encontrarElementoUnico(int[] array) {
        int resultado = 0;
        for (int num : array) {
            resultado ^= num; 
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 1, 3, 2};
        int elementoUnico = encontrarElementoUnico(array);
        System.out.println("Elemento único: " + elementoUnico);
    }
}