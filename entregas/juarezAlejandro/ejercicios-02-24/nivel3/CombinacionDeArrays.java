package nivel3;

public class CombinacionDeArrays {
    public static void main(String[] args) {
        int[] array1 = { 1, 4, 7 };
        int[] array2 = { 2, 5, 8 };
        int[] array3 = { 3, 6, 9 };

        int[] result = combinarArrays(array1, array2, array3);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] combinarArrays(int[] array1, int[] array2, int[] array3) {
        int totalLength = array1.length + array2.length + array3.length;
        int[] result = new int[totalLength];
        int index = 0;

        for (int i = 0; i < array1.length; i++) {
            result[index++] = array1[i];
            result[index++] = array2[i];
            result[index++] = array3[i];
        }

        return result;
    }
}