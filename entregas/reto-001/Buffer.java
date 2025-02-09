class Buffer {
   int FRAME_WIDTH = 7;
   int FRAME_HEIGTH = 3;

   int width;
   int height;
   Frame frames[] = new Frame[2];

   String template1 = "...%%....#..#..#....#";
   String template2 = "...**....#..#..#....!";

   public Buffer(int width, int height) {
      this.width = width;
      this.height = height;

      frames[0] = new Frame(FRAME_WIDTH, FRAME_HEIGTH, template1);
      frames[1] = new Frame(FRAME_WIDTH, FRAME_HEIGTH, template2);
   }

   public void initialize() {
      this.renderFrame(0, 0);
   }

   private void renderFrame(int x, int y) {
      String[] firstFrame = frames[0].getRenderedLines();
      String[] secondFrame = frames[1].getRenderedLines();

      for (int i = 0; i < FRAME_HEIGTH; i++) {
         System.out.println(firstFrame[i] + "" + secondFrame[i]);
      }
   }

   public void paintPixel(int x, int y, String color, String content) {
   }
}
