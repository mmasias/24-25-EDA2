package entregas.martinezDiego.nivel2;

public class ElementoMayoritario {
    public static int encontrarElementoMayoritario(int[] numeros) {
        int n = numeros.length;
        int candidato = numeros[n / 2];
        return candidato;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 1, 1, 2, 2, 2, 3};

        System.out.print("Entrada: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int resultado = encontrarElementoMayoritario(numeros);
        System.out.println("Salida: " + resultado);
    }
}

