class ElementoMayoritario2 {
    
    public static int encontrarElementoMayoritario(int[] numeros) {
        if (numeros.length == 0) {
            return -1;
        }
        
        int candidatoMayoritario = numeros[0];
        int contadorApariciones = 1;
        
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] == candidatoMayoritario) {
                contadorApariciones++;
            } else {
                contadorApariciones--;
                
                if (contadorApariciones == 0) {
                    candidatoMayoritario = numeros[i];
                    contadorApariciones = 1;
                }
            }
        }
        
        int frecuenciaCandidato = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == candidatoMayoritario) {
                frecuenciaCandidato++;
            }
        }
        
        if (frecuenciaCandidato > numeros.length / 2) {
            return candidatoMayoritario;
        } else {
            return -1;
        }
    }
    
    public static void main(String[] args) {
        int[] arrayNumeros = {1, 1, 1, 1, 2, 2, 3};
        int resultadoMayoritario = encontrarElementoMayoritario(arrayNumeros);
        
        if (resultadoMayoritario != -1) {
            System.out.println("El elemento mayoritario es: " + resultadoMayoritario);
            
            int conteoApariciones = 0;
            for (int numero : arrayNumeros) {
                if (numero == resultadoMayoritario) {
                    conteoApariciones++;
                }
            }
            System.out.println("Aparece " + conteoApariciones + " veces en un array de longitud " + arrayNumeros.length);
        } else {
            System.out.println("No hay elemento mayoritario");
        }
    }
}