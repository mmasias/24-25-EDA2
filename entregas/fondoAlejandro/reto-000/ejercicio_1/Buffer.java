class Buffer {
    void entrelazarFrames() {
        System.out.println("Entrelazando frames...");
        for (int i = 0; i < 2; i++) {
            System.out.println("Procesando frame " + (i + 1));
        }
    }
    
    void alternanciaRapida() {
        System.out.println("Ejecutando alternancia rápida de frames");
        for (int i = 0; i < 5; i++) {
            System.out.println("Alternando a frame " + ((i % 2) + 1));
        }
    }
}
