class Alternancia {
    void combinarColoresBase() {
        System.out.println("Combinando colores base...");
        for (int i = 0; i < 3; i++) {
            System.out.println("Mezclando combinaciones de colores...");
        }
    }
    
    void alternarColores() {
        System.out.println("Alternando colores...");
        for (int i = 0; i < 3; i++) {
            System.out.println("Cambiando a otro color...");
        }
    }
    
    void temporizado() {
        System.out.println("Aplicando temporización en la alternancia de colores...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error en la temporización");
        }
    }
}