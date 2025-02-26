package Reto002.Nivel4;

public class SumaMaxima {
    public static int[] maxSubarray(int[] arr) {
        int n = arr.length;
        int maxSum = arr[0];
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        int[] result = new int[endIndex - startIndex + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[startIndex + i];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] subarray = maxSubarray(arr);
        System.out.print("Salida: [");
        for (int i = 0; i < subarray.length; i++) {
            System.out.print(subarray[i]);
            if (i < subarray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

