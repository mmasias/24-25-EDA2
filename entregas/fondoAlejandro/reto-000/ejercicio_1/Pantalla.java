class Pantalla {
    int alto;
    int ancho;
    
    void mostrarEntrelazado() {
        System.out.println("Mostrando pantalla en modo entrelazado");
        for (int i = 0; i < 2; i++) {
            System.out.println("Refrescando pantalla...");
        }
    }
}
