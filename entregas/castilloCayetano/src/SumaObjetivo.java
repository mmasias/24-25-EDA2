public class SumaObjetivo {
    //Completado
    public static void main(String[] args) {
        imprimirObjetivos();
        
    }
    public void mostrar(){
        imprimirObjetivos();
    }

    public static int[][] sumaObjetivo(int[] numeros, int objetivo) {
        int[][] resultados = new int[numeros.length * (numeros.length - 1) / 2][2];
        int index = 0;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] + numeros[j] == objetivo) {
                    resultados[index][0] = numeros[i];
                    resultados[index][1] = numeros[j];
                    index++;
                }
            }
        }
        return resultados;
    }
    public static void imprimirObjetivos() {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int objetivo = 10;
        int[][] resultados = sumaObjetivo(numeros, objetivo);
        
        System.out.println("Resultados:");
        for (int[] resultado : resultados) {
            if (resultado[0] != 0 || resultado[1] != 0) {
                System.out.println(resultado[0] + " + " + resultado[1] + " = " + objetivo);
            }
        }
    }
}
