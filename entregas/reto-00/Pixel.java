class Pixel {
   String color;
   String content;

   public Pixel(String color, String content) {
       this.color = color;
       this.content = content;
   }

   public void changeColor(String color) {
       this.color = color;
   }

   public void changeContent(String content) {
       this.content = content;
   }
}
