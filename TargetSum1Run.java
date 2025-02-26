public class TargetSum1Run {
    public static void main(String[] args) {
        int[] numbers = {3,2,9,8};
        int target = 10;
        int[][] matrizCalculadora;

        matrizCalculadora = saveNumbers(numbers);
        /* for(int i=0;i<matrizCalculadora.length;i++){
            for(int j=0;j<matrizCalculadora.length;j++){
                System.out.print(matrizCalculadora[i][j]);
            }
            System.out.println();
        } */

        calcAndFind(matrizCalculadora, target);

    }

    public static int[][] saveNumbers(int[] numbers){
        int[][] matrizCalculadora = new int[numbers.length+1][numbers.length+1];
    
        for(int i = 1;i<=numbers.length;i++){
            matrizCalculadora[0][i] = numbers[i-1];
            matrizCalculadora[i][0] = numbers[i-1];
        }
    
        return matrizCalculadora;
    }
    

    public static void calcAndFind(int[][] matrizCalculadora, int target){
        int[][] matrizResultante = new int[matrizCalculadora.length][matrizCalculadora.length];

        for(int i=1;i<matrizCalculadora.length;i++){
            for(int j=1;j<matrizCalculadora[i].length;j++){
                matrizResultante[i][j] = matrizCalculadora[0][i] + matrizCalculadora[j][0];
            }
        }

        System.out.println("Matriz de sumas:");
        for (int i = 0; i < matrizResultante.length; i++) {
            for (int j = 0; j < matrizResultante[0].length; j++) {
                System.out.print(matrizResultante[i][j] + "\t");
            }
            System.out.println();
        }
    }

}

