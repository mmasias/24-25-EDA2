package entregas.lopezMartin.reto002.src;

public class ElementoUnico {
    public static int encontrarUnico1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean esUnico = true;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    esUnico = false;
                    break;
                }
            }
            if (esUnico) {
                return arr[i];
            }
        }
        return -1; 
    }

    public static int encontrarUnico2(int[] arr) {
        int unico = 0;
        
        for (int i = 0; i < arr.length; i++) {
            unico = unico ^ arr[i];
        }
        
        return unico;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2};
        int resultado = encontrarUnico1(arr);
        System.out.println("Elemento único: " + resultado);
    }
}
