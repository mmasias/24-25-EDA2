class PuntoEquilibrio {
    public static int encontrarPuntoEquilibrio(int[] equilibrio) {
        if (equilibrio == null || equilibrio.length == 0) {
            return -1;
        }
        
        int sumaTotal = 0;
        for (int punto : equilibrio) {
            sumaTotal += punto;
        }
        
        int sumaIzquierda = 0;
        for (int i = 0; i < equilibrio.length; i++) {
            if (sumaIzquierda == sumaTotal - sumaIzquierda - equilibrio[i]) {
                return i;
            }
            sumaIzquierda += equilibrio[i];
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] ejemplo = {1, 2, 3, 4, 6};
        
        System.out.print("El punto de equilibrio es: ");
        System.out.print(encontrarPuntoEquilibrio(ejemplo));
    }
}
