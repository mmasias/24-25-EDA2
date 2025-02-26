package entregas.martinezDiego.nivel1;

public class SumaObjetivo {
    public static int[] encontrarIndices(int[] numeros, int objetivo) {
        for (int indiceUno = 0; indiceUno < numeros.length; indiceUno++) {
            for (int indiceDos = indiceUno + 1; indiceDos < numeros.length; indiceDos++) {
                if (numeros[indiceUno] + numeros[indiceDos] == objetivo) {
                    return new int[]{indiceUno, indiceDos};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numeros = {3, 2, 9, 8};
        int objetivo = 10;
        System.out.print("Entrada: números [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("], objetivo " + objetivo);
        
        int[] resultado = encontrarIndices(numeros, objetivo);
        
        if (resultado[0] == -1) {
            System.out.println("No se encontraron dos números que sumen " + objetivo);
        } else {
            System.out.print("Salida: índices [");
            System.out.print(resultado[0] + ", " + resultado[1]);
            System.out.println("] (" + numeros[resultado[0]] + " + " + numeros[resultado[1]] + " = " + objetivo + ")");
        }
    }
}

