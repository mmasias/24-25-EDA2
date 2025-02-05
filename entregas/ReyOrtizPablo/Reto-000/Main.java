public class Main {
    public static void main(String[] args) {
        int anchura = 5; 
        int altura = 3;  

        Pixel[][] pixels = new Pixel[altura][anchura];
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                pixels[i][j] = new Pixel(j, i, 'R');
            }
        }

        
        Frame frame = new Frame(pixels, altura, anchura);

       
        frame.setPixel(1, 1, 'Y'); 
        frame.setPixel(3, 2, 'B');

        frame.renderizar();
    }
}
