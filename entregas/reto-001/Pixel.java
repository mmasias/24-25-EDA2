class Pixel {
   char color;
   char content;

   public Pixel(char color, char content) {
       this.color = color;
       this.content = content;
   }

   public void changeColor(char color) {
       this.color = color;
   }

   public void changeContent(char content) {
       this.content = content;
   }

   public char getContent() {
       return this.content;
   }

   public char getColor() {
       return this.color;
   }
}
