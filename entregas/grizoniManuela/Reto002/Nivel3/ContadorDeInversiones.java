package Reto002.Nivel3;

public class ContadorDeInversiones {
    static String pairsResult = "";
    
    public static long mergeSortAndCount(int[] arr, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count += mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid + 1, right);
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }
    
    public static long mergeAndCount(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        long inversions = 0;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                inversions += (n1 - i);
                for (int x = i; x < n1; x++) {
                    if (pairsResult.length() != 0) {
                        pairsResult += ", ";
                    }
                    pairsResult += "(" + leftArr[x] + "," + rightArr[j - 1] + ")";
                }
            }
        }
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
        return inversions;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        long inversions = mergeSortAndCount(arr, 0, arr.length - 1);
        System.out.println("Salida: " + inversions + " " + pairsResult);
    }
}
