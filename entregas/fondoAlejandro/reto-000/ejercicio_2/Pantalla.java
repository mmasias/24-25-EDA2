class Pantalla {
    int alto;
    int ancho;
    
    void duplicarFrames() {
        System.out.println("Duplicando frames...");
        for (int i = 0; i < 2; i++) {
            System.out.println("Proceso de duplicación en curso...");
        }
    }
    
    void mostrarDuplicado() {
        System.out.println("Mostrando frames duplicados");
        for (int i = 0; i < 2; i++) {
            System.out.println("Refrescando pantalla con frames duplicados...");
        }
    }

    public void mostrarEntrelazado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarEntrelazado'");
    }
}