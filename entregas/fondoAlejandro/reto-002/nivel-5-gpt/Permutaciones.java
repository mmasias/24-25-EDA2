class Permutaciones {
    public static void generarPermutaciones(String cadena, String resultado) {
        if (cadena.length() == 0) {
            System.out.println(resultado);
            return;
        }
        
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            String restante = cadena.substring(0, i) + cadena.substring(i + 1);
            generarPermutaciones(restante, resultado + caracter);
        }
    }
    
    public static void main(String[] args) {
        String entrada = "abc";
        System.out.println("Permutaciones de '" + entrada + "':");
        generarPermutaciones(entrada, "");
    }
}
