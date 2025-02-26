package nivel3;

public class MedianaEnStream {
    public static void main(String[] args) {
        int[] stream = { 1, 3, 2, 4, 5 };
        double[] medianas = encontrarMedianaEnStream(stream);
        for (double mediana : medianas) {
            System.out.print(mediana + " ");
        }
    }

    public static double[] encontrarMedianaEnStream(int[] stream) {
        int n = stream.length;
        double[] medianas = new double[n];
        int[] arr = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[count] = stream[i];
            count++;
            medianas[i] = calcularMediana(arr, count);
        }

        return medianas;
    }

    public static double calcularMediana(int[] arr, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        if (count % 2 == 0) {
            return (arr[count / 2 - 1] + arr[count / 2]) / 2.0;
        } else {
            return arr[count / 2];
        }
    }
}