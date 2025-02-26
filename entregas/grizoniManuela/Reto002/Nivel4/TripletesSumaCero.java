package Reto002.Nivel4;

public class TripletesSumaCero {
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    
    public static void threeSum(int[] arr) {
        sort(arr);
        String output = "";
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    String triplet = "[" + arr[i] + "," + arr[left] + "," + arr[right] + "]";
                    if (output.equals("")) {
                        output = triplet;
                    } else {
                        output = output + ", " + triplet;
                    }
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1]) left++;
                    while (left < right && arr[right] == arr[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println("Salida: [" + output + "]");
    }
    
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        threeSum(arr);
    }
}

