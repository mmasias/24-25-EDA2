package Reto002.Nivel5;

public class Subconjuntos {
    static String output = "";
    
    public static void generarCombinaciones(int[] arr, int start, int k, int[] current, int currentIndex) {
        if (currentIndex == k) {
            String subset = "[";
            for (int i = 0; i < k; i++) {
                subset += current[i];
                if (i < k - 1) {
                    subset += ",";
                }
            }
            subset += "]";
            if (!output.equals("")) {
                output += ", ";
            }
            output += subset;
            return;
        }
        for (int i = start; i < arr.length; i++) {
            current[currentIndex] = arr[i];
            generarCombinaciones(arr, i + 1, k, current, currentIndex + 1);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        output = "";
        for (int k = 0; k <= arr.length; k++) {
            generarCombinaciones(arr, 0, k, new int[k], 0);
        }
        System.out.println("Salida: [" + output + "]");
    }
}
