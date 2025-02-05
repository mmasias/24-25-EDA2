class Frame {
   int width;
   int height;
   Pixel pixels[];

   public Frame(int width, int height) {
       this.width = width;
       this.height= height;
   }

   public void refresh() {}
   public void render() {}
   public void reset() {}

   public void paintPixel(int x, int y, String color, String content) {}
}
