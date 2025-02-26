package Nivel5;

public class Subconjuntos {
    public static void main(String[] args) {
        int[] numeros = { 1, 2, 3 };
        System.out.println("Todos los subconjuntos:");
        generarSubconjuntos(numeros, 0, "");
    }

    public static void generarSubconjuntos(int[] numeros, int index, String subconjunto) {
        if (index == numeros.length) {
            System.out.println("[" + subconjunto + "]");
            return;
        }

        generarSubconjuntos(numeros, index + 1, subconjunto);

        if (!subconjunto.isEmpty()) {
            subconjunto += ",";
        }
        subconjunto += numeros[index];
        generarSubconjuntos(numeros, index + 1, subconjunto);
    }
}
