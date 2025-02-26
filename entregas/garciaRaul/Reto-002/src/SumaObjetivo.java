public class SumaObjetivo {
    public int[] buscarIndices(int[] numeros, int objetivo) {

        int desplazamiento = 1000;
        int[] valorAIndice = new int[2001];

        for (int i = 0; i < valorAIndice.length; i++) {
            valorAIndice[i] = -1;
        }

        for (int i = 0; i < numeros.length; i++) {
            int complemento = objetivo - numeros[i];

            if (complemento >= -1000 && complemento <= 1000 &&
                    valorAIndice[complemento + desplazamiento] != -1) {
                return new int[] { valorAIndice[complemento + desplazamiento], i };
            }

            valorAIndice[numeros[i] + desplazamiento] = i;
        }

        return new int[] { -1, -1 };
    }
}