public class SubsetGenerator {

    public static void main(String[] args) {
        int[] set = { 1, 2, 3 };
        int[][] result = generateSubsets(set);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print("[");
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
                if (j < result[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[][] generateSubsets(int[] set) {
        if (set == null)
            return new int[0][0];

        int n = set.length;
        int totalSubsets = 1 << n;

        int[] subsetSizes = new int[totalSubsets];
        for (int i = 0; i < totalSubsets; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    count++;
                }
            }
            subsetSizes[i] = count;
        }

        int[][] result = new int[totalSubsets][];
        for (int i = 0; i < totalSubsets; i++) {
            result[i] = new int[subsetSizes[i]];
        }

        for (int i = 0; i < totalSubsets; i++) {
            int idx = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    result[i][idx++] = set[j];
                }
            }
        }

        return result;
    }
}