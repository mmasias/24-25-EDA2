package Nivel2;

public class ElementoUnico {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 2 };
        System.out.println(encontrarUnicoBruto(arr));
    }

    public static int encontrarUnicoBruto(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count == 1)
                return arr[i];
        }
        return -1; // No debería ocurrir si la entrada es válida
    }
}
