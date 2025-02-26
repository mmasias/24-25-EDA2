package entregas.celayaIker;

import java.util.Arrays;

public class TriangulosPosibles {
    public static boolean existeTriangulo(int[] nums) {
        int n = nums.length;
        if (n < 3) return false; 

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = i + 2;
            while (k < n) {
                if (nums[i] + nums[j] > nums[k]) {
                    System.out.println("true (" + nums[i] + "," + nums[j] + "," + nums[k] + ")");
                    return true;
                }
                k++;
                j++;
            }
        }

        System.out.println("false");
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7};
        existeTriangulo(nums);
    }
}

