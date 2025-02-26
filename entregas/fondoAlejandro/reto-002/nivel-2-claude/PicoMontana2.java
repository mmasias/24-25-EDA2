class PicoMontana2 {
    
    public static int encontrarPicoMontana(int[] numerosMontana) {
        if (numerosMontana.length == 0) {
            return -1;
        }
        
        if (numerosMontana.length == 1) {
            return numerosMontana[0];
        }
        
        int inicioRango = 0;
        int finRango = numerosMontana.length - 1;
        
        while (inicioRango <= finRango) {
            int puntoMedio = inicioRango + (finRango - inicioRango) / 2;
            
            boolean esMayorQueIzquierda = puntoMedio == 0 || numerosMontana[puntoMedio] > numerosMontana[puntoMedio - 1];
            boolean esMayorQueDerecha = puntoMedio == numerosMontana.length - 1 || 
                                        numerosMontana[puntoMedio] > numerosMontana[puntoMedio + 1];
                                        
            if (esMayorQueIzquierda && esMayorQueDerecha) {
                return numerosMontana[puntoMedio];
            } else if (esMayorQueIzquierda) {
                inicioRango = puntoMedio + 1;
            } else {
                finRango = puntoMedio - 1;
            }
        }
        
        return -1;
    }
    
    public static int encontrarIndicePicoMontana(int[] numerosMontana) {
        if (numerosMontana.length == 0) {
            return -1;
        }
        
        if (numerosMontana.length == 1) {
            return 0;
        }
        
        int inicioRango = 0;
        int finRango = numerosMontana.length - 1;
        
        while (inicioRango <= finRango) {
            int puntoMedio = inicioRango + (finRango - inicioRango) / 2;
            
            boolean esMayorQueIzquierda = puntoMedio == 0 || numerosMontana[puntoMedio] > numerosMontana[puntoMedio - 1];
            boolean esMayorQueDerecha = puntoMedio == numerosMontana.length - 1 || 
                                        numerosMontana[puntoMedio] > numerosMontana[puntoMedio + 1];
                                        
            if (esMayorQueIzquierda && esMayorQueDerecha) {
                return puntoMedio;
            } else if (esMayorQueIzquierda) {
                inicioRango = puntoMedio + 1;
            } else {
                finRango = puntoMedio - 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] montanaArray = {1, 3, 5, 7, 6, 4, 2};
        int valorPico = encontrarPicoMontana(montanaArray);
        int indicePico = encontrarIndicePicoMontana(montanaArray);
        
        System.out.println("El valor del pico es: " + valorPico);
        System.out.println("El pico está en el índice: " + indicePico);
    }
}