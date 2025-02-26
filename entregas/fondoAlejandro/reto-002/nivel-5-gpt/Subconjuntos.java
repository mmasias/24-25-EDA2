class Subconjuntos {
    public static void generarSubconjuntos(int[] conjunto, int indice, String[] subconjuntos, String subconjunto, int[] contador) {
        if (indice == conjunto.length) {
            subconjuntos[contador[0]] = "[" + subconjunto + "]";
            contador[0]++;
            return;
        }

        generarSubconjuntos(conjunto, indice + 1, subconjuntos, subconjunto, contador);

        String nuevoSubconjunto = subconjunto.isEmpty() ? String.valueOf(conjunto[indice]) : subconjunto + ", " + conjunto[indice];
        generarSubconjuntos(conjunto, indice + 1, subconjuntos, nuevoSubconjunto, contador);
    }

    public static void main(String[] args) {
        int[] conjunto = {1, 2, 3};
        String[] subconjuntos = new String[(int) Math.pow(2, conjunto.length)];
        int[] contador = {0};

        System.out.print("Subconjuntos del conjunto: ");
        generarSubconjuntos(conjunto, 0, subconjuntos, "", contador);

        for (int i = 0; i < contador[0]; i++) {
            System.out.print(subconjuntos[i] + ", ");
        }

        if (contador[0] > 0) {
            System.out.print("\b\b");
        }
        System.out.println();
    }
}
