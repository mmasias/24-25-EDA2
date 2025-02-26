public class ArrayMontaña {
    public static void main(String[] args) {
        int[] entrada = { 1, 3, 5, 4, 2 };

        int i = 0;
        while (i < entrada.length - 1 && entrada[i] < entrada[i + 1]) {
            i++;
        }

        if (i == 0 || i == entrada.length - 1) {
            System.out.println(false);
            return;
        }

        while (i < entrada.length - 1 && entrada[i] > entrada[i + 1]) {
            i++;
        }

        if (i == entrada.length - 1) {
            System.out.println(true + ", es una montaña");
        } else {
            System.out.println(false);
        }
    }
}
