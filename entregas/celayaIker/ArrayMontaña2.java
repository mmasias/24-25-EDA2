package entregas.celayaIker;

public class ArrayMontaña2 {
    public static boolean esMontana(int[] nums) {
        int n = nums.length;
        if (n < 3) return false; 

        int izq = 0, der = n - 1;

        while (izq < n - 1 && nums[izq] < nums[izq + 1]) {
            izq++;
        }

        while (der > 0 && nums[der] < nums[der - 1]) {
            der--;
        }

        return izq == der && izq > 0 && der < n - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2}; 
        System.out.println("Es montaña: " + esMontana(nums));
    }
}
