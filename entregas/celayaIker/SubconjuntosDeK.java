package entregas.celayaIker;

public class SubconjuntosDeK {
    public static void generarSubconjuntos(int[] nums, int indice, int k, StringBuilder actual, int count) {
        if (count == k) {
            System.out.println("[" + actual.toString() + "]");
            return;
        }

        for (int i = indice; i < nums.length; i++) {
            int longitud = actual.length();
            if (longitud > 0) actual.append(",");
            actual.append(nums[i]);

            generarSubconjuntos(nums, i + 1, k, actual, count + 1);

            actual.setLength(longitud); 
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 2; 

        System.out.println("Subconjuntos de tamaño " + k + ":");
        generarSubconjuntos(nums, 0, k, new StringBuilder(), 0);
    }
}

