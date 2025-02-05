class Main {
  public static void main(String[] args) {
      Buffer buf = new Buffer();
      buf.initialize();
      buf.renderFrame(0, 0);
      buf.renderFrame(10, 0);
      buf.paintPixel(0, 0, "red", "Hello, World!");
      buf.paintPixel(10, 0, "red", "Hello, World!");

      buf.show();
  }
}
