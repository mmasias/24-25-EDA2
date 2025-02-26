public class TargetSum1Run {
    public static void main(String[] args) {
        int[] numbers = {3,2,9,8};
        int target = 10;
        int[][] calculatingMatrix;

        calculatingMatrix = saveNumbers(numbers);
        calcAndFind(calculatingMatrix, target);

    }

    public static int[][] saveNumbers(int[] numbers){
        int[][] calculatingMatrix = new int[numbers.length+1][numbers.length+1];
    
        for(int i = 1;i<=numbers.length;i++){
            calculatingMatrix[0][i] = numbers[i-1];
            calculatingMatrix[i][0] = numbers[i-1];
        }
    
        return calculatingMatrix;
    }
    

    public static void calcAndFind(int[][] calculatingMatrix, int target){
        int[][] resultingMatrix = new int[calculatingMatrix.length][calculatingMatrix.length];

        for(int i=0;i<calculatingMatrix.length;i++){
            System.out.print(calculatingMatrix[0][i] + "\t");
        }
        System.out.println();

        for(int i=1;i<calculatingMatrix.length;i++){
            System.out.print(calculatingMatrix[i][0] + "\t");

            for(int j=1;j<calculatingMatrix[i].length;j++){
                resultingMatrix[i][j] = calculatingMatrix[0][i] + calculatingMatrix[j][0];
                System.out.print(resultingMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 1; i < calculatingMatrix.length; i++) {
            for (int j = 1; j < calculatingMatrix[i].length; j++) {
                if (i != j && resultingMatrix[i][j] == target) {
                    System.out.println("Par encontrado: (" + calculatingMatrix[0][i] + ", " + calculatingMatrix[j][0] + ")");
                    System.out.println("Índices: [" + (i - 1) + "], [" + (j - 1) + "]");
                }
            }
        }
        
    }

}

