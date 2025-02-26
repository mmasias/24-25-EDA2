public class GeneradorPermutaciones {
    public static void main(String[] args) {
        String entrada = "abc";
        System.out.println("Permutaciones:");
        generarPermutaciones(entrada, "");
        
        String entradaDuplicada = "aabc";
        System.out.println("Permutaciones sin duplicados:");
        generarPermutacionesUnicas(entradaDuplicada, "", new char[entradaDuplicada.length()], 0);
    }

    public static void generarPermutaciones(String str, String prefijo) {
        if (str.isEmpty()) {
            System.out.println(prefijo);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            generarPermutaciones(str.substring(0, i) + str.substring(i + 1), prefijo + str.charAt(i));
        }
    }

    public static void generarPermutacionesUnicas(String str, String prefijo, char[] resultado, int nivel) {
        if (str.isEmpty()) {
            boolean repetido = false;
            for (int i = 0; i < nivel; i++) {
                if (resultado[i] == prefijo.charAt(0)) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                System.out.println(prefijo);
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            resultado[nivel] = str.charAt(i);
            generarPermutacionesUnicas(str.substring(0, i) + str.substring(i + 1), prefijo + str.charAt(i), resultado, nivel + 1);
        }
    }
}
