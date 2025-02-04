class Frames {
    int[][] frame1 = new int[3][7];
    int[][] frame2 = new int[3][7];
    
    void actualizarFrame() {
        System.out.println("Actualizando frame...");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                frame1[i][j] = (int) (Math.random() * 256);
                frame2[i][j] = (int) (Math.random() * 256);
            }
        }
        System.out.println("Frames actualizados correctamente");
    }
}