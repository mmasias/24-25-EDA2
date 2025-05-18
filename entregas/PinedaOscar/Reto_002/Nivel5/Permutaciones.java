package entregas.PinedaOscar.Reto_002.Nivel5;

public class Permutaciones {

    public static void generarPermutaciones(String str) {
        permutacionesRecursivas(str.toCharArray(), 0);
    }


    private static void permutacionesRecursivas(char[] arr, int indice) {
        if (indice == arr.length - 1) {
            System.out.println(new String(arr)); 
            return;
        }

        for (int i = indice; i < arr.length; i++) {

            intercambiar(arr, indice, i);

            permutacionesRecursivas(arr, indice + 1);

            intercambiar(arr, indice, i);
        }
    }


    private static void intercambiar(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println("Permutaciones de " + str + ":");
        generarPermutaciones(str);
    }
}