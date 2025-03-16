package entregas.NevesKelvia.Ejercicio17_02;

public class Concierto {
    public static void main(String[] args) {
        
        Instrumento guitarra1 = new Guitarra();
        Instrumento guitarra2 = new Guitarra();
        Instrumento violin = new Violin();

       
        System.out.println(guitarra1.equals(guitarra2)); 
        System.out.println(guitarra1.equals(violin));    
    }
}