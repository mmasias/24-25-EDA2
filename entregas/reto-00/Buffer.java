class Buffer {
   int width;
   int height;
   int frames[];

   public Buffer(int width, int height) {
       this.width = width;
       this.height= height;
   }

   public void initialize() {}
   public void renderFrame(int x, int y) {}
   public void paintPixel(int x, int y, String color, String content) {}
   public void show() {}
}
