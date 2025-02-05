class Pixel {
    int pixel;
    
    void actualizarPixel() {
        System.out.println("Actualizando pixel con valor: " + pixel);
        pixel = (int) (Math.random() * 256);
        System.out.println("Nuevo valor del pixel: " + pixel);
    }
}

