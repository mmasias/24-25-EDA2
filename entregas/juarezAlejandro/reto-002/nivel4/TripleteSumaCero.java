package nivel4;

public class TripleteSumaCero {
    public static void main(String[] args) {
        int[] entrada = { -1, 0, 1, 2, -1, -4 };
        int n = entrada.length;
        boolean encontrado = false;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (entrada[j] > entrada[j + 1]) {
                    int temp = entrada[j];
                    entrada[j] = entrada[j + 1];
                    entrada[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && entrada[i] == entrada[i - 1])
                continue;

            int izquierda = i + 1;
            int derecha = n - 1;

            while (izquierda < derecha) {
                int suma = entrada[i] + entrada[izquierda] + entrada[derecha];
                if (suma == 0) {
                    System.out.println("true [" + entrada[i] + "," + entrada[izquierda] + "," + entrada[derecha] + "]");
                    encontrado = true;
                    while (izquierda < derecha && entrada[izquierda] == entrada[izquierda + 1])
                        izquierda++;
                    while (izquierda < derecha && entrada[derecha] == entrada[derecha - 1])
                        derecha--;
                    izquierda++;
                    derecha--;
                } else if (suma < 0) {
                    izquierda++;
                } else {
                    derecha--;
                }
            }
        }

        if (!encontrado) {
            System.out.println("false");
        }
    }
}
