class ProductoDefectuoso2 {
    
    public static int encontrarPrimerDefectuoso(boolean[] productosEnLinea) {
        if (productosEnLinea.length == 0) {
            return -1;
        }
        
        int inicioRango = 0;
        int finRango = productosEnLinea.length - 1;
        
        if (productosEnLinea[inicioRango]) {
            return inicioRango;
        }
        
        if (!productosEnLinea[finRango]) {
            return -1;
        }
        
        while (inicioRango < finRango) {
            int puntoMedio = inicioRango + (finRango - inicioRango) / 2;
            
            if (!productosEnLinea[puntoMedio] && productosEnLinea[puntoMedio + 1]) {
                return puntoMedio + 1;
            } else if (productosEnLinea[puntoMedio]) {
                finRango = puntoMedio;
            } else {
                inicioRango = puntoMedio + 1;
            }
        }
        
        return inicioRango;
    }
    
    public static void main(String[] args) {
        boolean[] lineaProduccion = {false, false, false, true, true};
        int indiceDefectuoso = encontrarPrimerDefectuoso(lineaProduccion);
        
        if (indiceDefectuoso != -1) {
            System.out.println("El primer producto defectuoso está en el índice: " + indiceDefectuoso);
        } else {
            System.out.println("No se encontraron productos defectuosos");
        }
    }
}