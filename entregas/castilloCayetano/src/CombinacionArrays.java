public class CombinacionArrays{
    //Completado
    public static void main(String[] args) {
        imprimirArrayCombinado();
    }
    public void mostrar(){
        imprimirArrayCombinado();
    }

    public static void imprimirArrayCombinado(){
        int[][] arrays = {{1,4,7}, {2,5,8}, {3,6,9}};
        int[] arrayCombinado = combinarArrays(arrays);
        System.out.print("[");
        for (int i =0; i < arrayCombinado.length; i++){
            System.out.print(arrayCombinado[i]);
            if (i < arrayCombinado.length - 1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static int[] combinarArrays(int[][] arrays){
        int[] arrayCombinado = new int[arrays.length * arrays[0].length];
        int[] indices = new int[arrays.length];
        for (int i = 0; i < arrayCombinado.length; i++){
            int menor = Integer.MAX_VALUE;
            int indiceMenor = -1;
            for (int j = 0; j < arrays.length; j++){
                if (indices[j] < arrays[j].length && arrays[j][indices[j]] < menor){
                    menor = arrays[j][indices[j]];
                    indiceMenor = j;
                }
            }
            arrayCombinado[i] = menor;
            indices[indiceMenor]++;
        }
        return arrayCombinado;
    }
}