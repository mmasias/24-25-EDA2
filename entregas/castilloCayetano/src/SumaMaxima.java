public class SumaMaxima {
    // Completado
    public static void main(String[] args) {
        imprimirSumaMaxima();
    }
    public void mostrar(){
        imprimirSumaMaxima();
    }

    public static void imprimirSumaMaxima() {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] resultado = encontrarSumaMaxima(array);
        System.out.println("Suma máxima: " + resultado[0]);
        System.out.print("Subarreglo con suma máxima: [");
        for (int i = resultado[1]; i <= resultado[2]; i++) {
            System.out.print(array[i]);
            if (i < resultado[2]) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] encontrarSumaMaxima(int[] array) {
        if (array == null || array.length < 1) {
            return new int[]{0, -1, -1};
        }
        int sumaMaxima = array[0];
        int sumaActual = array[0];
        int inicio = 0;
        int fin = 0;
        int tempInicio = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > sumaActual + array[i]) {
                sumaActual = array[i];
                tempInicio = i;
            } else {
                sumaActual += array[i];
            }

            if (sumaActual > sumaMaxima) {
                sumaMaxima = sumaActual;
                inicio = tempInicio;
                fin = i;
            }
        }
        return new int[]{sumaMaxima, inicio, fin};
    }
}