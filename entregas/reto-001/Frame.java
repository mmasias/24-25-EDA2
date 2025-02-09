class Frame {
   int width;
   int height;
   Pixel pixels[][];

   String template1 = "...%%....#..#..#....#";

   public Frame(int width, int height, String template) {
      this.width = width;
      this.height = height;
      pixels = new Pixel[height][width];

      for (int i = 0; i < height; i++) {
         for (int j = 0; j < width; j++) {
            int index = (i * width + j) % template.length();
            pixels[i][j] = new Pixel(' ', template.charAt(index));
         }
      }

   }

   public String[] getRenderedLines() {
      String[] lines = new String[height];

      for (int i = 0; i < height; i++) {
         StringBuilder line = new StringBuilder();
         for (int j = 0; j < width; j++) {
            line.append(pixels[i][j].getContent());
         }
         lines[i] = line.toString();
      }

      return lines;
   }

   public void paintPixel(int x, int y, String color, String content) {
   }
}
