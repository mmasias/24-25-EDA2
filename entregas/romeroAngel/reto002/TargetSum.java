public class TargetSum {

    public static void main(String[] args) {
        int[] numeros = {3,2,9,8};
        int objetivo = 10;
        int[] resultado = encontrarIndices(numeros, objetivo);

        System.out.println("Indices: [" + resultado[0] + "], [" + resultado[1] + "] | (" + numeros[resultado[0]] + " + " + numeros[resultado[1]] + ") = " + (numeros[resultado[0]] + numeros[resultado[1]]));
                
    }
            
    public static int[] encontrarIndices(int[] numeros, int objetivo){
        for(int i = 0;i<numeros.length;i++){
            for(int j = i+1;j<numeros.length;j++){
                if(numeros[i]+numeros[j] == objetivo){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}