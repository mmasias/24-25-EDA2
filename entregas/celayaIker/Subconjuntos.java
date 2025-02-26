package entregas.celayaIker;

public class Subconjuntos {
    public static void generarSubconjuntos(int[] nums, int indice, StringBuilder actual) {
        System.out.println("[" + actual.toString() + "]");

        for (int i = indice; i < nums.length; i++) {
            int longitud = actual.length();
            if (longitud > 0) actual.append(",");
            actual.append(nums[i]);

            generarSubconjuntos(nums, i + 1, actual);

            actual.setLength(longitud);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Subconjuntos:");
        System.out.println("[]");
        generarSubconjuntos(nums, 0, new StringBuilder());
    }
}
