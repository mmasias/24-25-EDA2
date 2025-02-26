public class SumaObjetivo {
    public static void main(String[] args) {
        int objetivo = 10;
        int[] entrada = { 3, 2, 9, 8 };

        int[] indices = new int[entrada.length];
        int indiceCount = 0;

        for (int i = 0; i < entrada.length; i++) {
            for (int j = i + 1; j < entrada.length; j++) {
                if (entrada[i] + entrada[j] == objetivo) {
                    indices[indiceCount++] = i;
                    indices[indiceCount++] = j;
                    break;
                }
            }
            if (indiceCount > 0) {
                break;
            }
        }

        System.out.print("Índices: [");
        for (int i = 0; i < indiceCount; i++) {
            System.out.print(indices[i]);
            if (i < indiceCount - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.println("Valores: [" + entrada[indices[0]] + " + " + entrada[indices[1]] + "]" + " = " + objetivo);
    }
}
