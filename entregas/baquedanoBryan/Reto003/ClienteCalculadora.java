package entregas.baquedanoBryan.Reto003;

import java.util.Scanner;

public class ClienteCalculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese una expresión infija (ejemplo: 3+5*2): ");
        String expresionInfija = scanner.nextLine(); 
        
        System.out.println("Expresión infija: " + expresionInfija);
        
        String expresionPostfijaIterativa = NotacionPolacaInversa.infijaAPostfijaIterativo(expresionInfija);
        System.out.println("Expresión postfija (iterativa): " + expresionPostfijaIterativa);
        
        double resultadoIterativo = NotacionPolacaInversa.evaluarPostfija(expresionPostfijaIterativa);
        System.out.println("Resultado iterativo: " + resultadoIterativo);
        

        String expresionPostfijaRecursiva = NotacionPolacaInversa.infijaAPostfijaRecursiva(expresionInfija);
        System.out.println("Expresión postfija (recursiva): " + expresionPostfijaRecursiva);
        
        double resultadoRecursivo = NotacionPolacaInversa.evaluarPostfija(expresionPostfijaRecursiva);
        System.out.println("Resultado recursivo: " + resultadoRecursivo);
        
        scanner.close();
    }
}
