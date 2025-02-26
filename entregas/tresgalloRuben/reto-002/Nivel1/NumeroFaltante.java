package Nivel1;
public class NumeroFaltante {
    public static int numeroFaltante(int[] nums) {
        int n = nums.length + 1;
        int suma = n * (n + 1) / 2;
        for (int num : nums) {
            suma -= num;
        }
        return suma;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6};
        int faltante = numeroFaltante(nums);
        System.out.println("Número faltante: " + faltante);
    }
}

