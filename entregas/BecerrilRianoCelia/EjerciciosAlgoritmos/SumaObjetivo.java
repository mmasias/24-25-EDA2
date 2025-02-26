package EjerciciosAlgoritmos;

public class SumaObjetivo {

    public static int[] encontrarIndices(int[] numeros, int objetivo) {
        int[] indices = new int[2];
        boolean encontrado = false;

        for (int indice = 0; indice < numeros.length; indice++) {
            int complemento = objetivo - numeros[indice];
            for (int indiceAnterior = 0;  indiceAnterior< indice; indiceAnterior++) {
                if (numeros[indiceAnterior] == complemento) {
                    indices[0] = indiceAnterior;
                    indices[1] = indice;
                    encontrado = true;
                
                }
            }
            if (encontrado) {
            
            }
        }

        if (!encontrado) {
            return new int[]{};
        }

        return indices;
    }

    public static void main(String[] args) {
        int[] numeros = {3, 2, 9, 8};
        int objetivo = 10;
        int[] resultado = encontrarIndices(numeros, objetivo);

        if (resultado.length == 0) {
            System.out.println("No se encontraron índices que sumen el objetivo.");
        } else {
            System.out.println("Índices: [" + resultado[0] + ", " + resultado[1] + "] (" + numeros[resultado[0]] + " + " + numeros[resultado[1]] + " = " + objetivo + ")");
        }
    }
}