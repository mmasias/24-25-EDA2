package EjerciciosAlgoritmos;

public class TriangulosPosibles {

    public static boolean esTriangulo(int ladoA, int ladoB, int ladoC) {
        return (ladoA + ladoB > ladoC) && (ladoA + ladoC > ladoB) && (ladoB + ladoC > ladoA);
    }

    public static void encontrarTriangulos(int[] lados) {
        int longitud = lados.length;
        boolean encontrado = false;

        for (int primerLado = 0; primerLado < longitud - 2; primerLado++) {
            for (int segundoLado = primerLado + 1; segundoLado < longitud - 1; segundoLado++) {
                for (int tercerLado = segundoLado + 1; tercerLado < longitud; tercerLado++) {
                    if (esTriangulo(lados[primerLado], lados[segundoLado], lados[tercerLado])) {
                        System.out.println("Triángulo posible: (" + lados[primerLado] + ", " + lados[segundoLado] + ", " + lados[tercerLado] + ")");
                        encontrado = true;
                    }
                }
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron triángulos posibles.");
        }
    }

    public static void main(String[] args) {
        int[] lados = {3, 4, 5, 6, 7};
        encontrarTriangulos(lados);
    }
}