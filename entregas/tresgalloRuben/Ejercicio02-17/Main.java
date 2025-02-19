package Ejercicio02_17;

public class Main {
    public static void main(String[] args) {
       
        InstrumentoMusical instrumento1 = new Guitarra("Fender");
        InstrumentoMusical instrumento2 = new Piano("Yamaha");
        InstrumentoMusical instrumento3 = new Violin("Stradivarius");
        
        instrumento1.tocar(); 
        instrumento2.tocar(); 
        instrumento3.tocar(); 
        
        InstrumentoMusical[] orquesta = new Guitarra[3]; 
        orquesta[0] = new Guitarra("Ibanez"); 
      
        
        Guitarra guitarraA = new Guitarra("Gibson");
        InstrumentoMusical instrumentoA = guitarraA;
        System.out.println(guitarraA.equals(instrumentoA)); 
    }
}
