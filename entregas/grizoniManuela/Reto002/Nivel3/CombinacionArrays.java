package Reto002.Nivel3;

public class CombinacionArrays {

    public static int[] mergeTwoArrays(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                merged[k++] = a[i++];
            } else {
                merged[k++] = b[j++];
            }
        }

        while (i < a.length) {
            merged[k++] = a[i++];
        }

        while (j < b.length) {
            merged[k++] = b[j++];
        }
        
        return merged;
    }

    public static int[] mergeKArrays(int[][] arrays, int start, int end) {
        if (start == end) {
            return arrays[start];
        }
        
        int mid = start + (end - start) / 2;
        int[] leftMerged = mergeKArrays(arrays, start, mid);
        int[] rightMerged = mergeKArrays(arrays, mid + 1, end);

        return mergeTwoArrays(leftMerged, rightMerged);
    }

    public static void main(String[] args) {
        int[][] arrays = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };
        
        int[] merged = mergeKArrays(arrays, 0, arrays.length - 1);
        
        System.out.print("Salida: [");
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i]);
            if (i < merged.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

