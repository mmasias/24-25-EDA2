public class PuntoEquilibrio {
    public static void main(String[] args) {
        int[] entrada = { 1, 2, 3, 4, 6 };
        int sumaTotal = 0;
        int sumaIzquierda = 0;

        for (int i = 0; i < entrada.length; i++) {
            sumaTotal += entrada[i];
        }

        for (int i = 0; i < entrada.length; i++) {
            sumaTotal -= entrada[i];

            if (sumaIzquierda == sumaTotal) {
                System.out.println("Punto de equilibrio en el índice: " + i);
                return;
            }

            sumaIzquierda += entrada[i];
        }

        System.out.println("No hay punto de equilibrio");
    }
}
