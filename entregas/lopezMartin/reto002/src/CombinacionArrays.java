package entregas.lopezMartin.ejerciciosAlgoritmos;

public class CombinacionArrays {

    public static int[] combinarArrays(int[][] arrays) {
        int k = arrays.length;
        int n = arrays[0].length;
        int[] resultado = new int[k * n];
        int indice = 0;
        
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                resultado[indice++] = arrays[i][j];
            }
        }
        
        for (int i = 0; i < resultado.length - 1; i++) {
            for (int j = 0; j < resultado.length - i - 1; j++) {
                if (resultado[j] > resultado[j + 1]) {
                    int temp = resultado[j];
                    resultado[j] = resultado[j + 1];
                    resultado[j + 1] = temp;
                }
            }
        }
        
        return resultado;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[] resultado = combinarArrays(arrays);
        System.out.print("Array combinado: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}
