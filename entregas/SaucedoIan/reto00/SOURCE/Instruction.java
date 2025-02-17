public class Instruction {
  private char color;
  private int posX, posY;
  private char pixelChar;

  public void createInstruction(Pixel pixel, int x, int y) {
    if (pixel != null) {
      this.pixelChar = pixel.getPixelValue().charAt(0);
      this.posX = x;
      this.posY = y;
      this.color = pixel.getColorCode().charAt(0);
    }
  }

  public int getPosX() {
    return posX;
  }

  public int getPosY() {
    return posY;
  }

  public char getPixelChar() {
    return pixelChar;
  }

  public char getColor() {
    return color;
  }
}