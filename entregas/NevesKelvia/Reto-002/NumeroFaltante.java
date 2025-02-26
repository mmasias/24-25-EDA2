public class NumeroFaltante {
    
    
    public static int encontrarNumeroFaltante(int[] numeros) {
        int numero = numeros.length + 1;
        int sumaEsperada = (numero * (numero + 1)) / 2; 
        int sumaReal = 0;
        
        for (int num : numeros) {
            sumaReal += num;
        }
        
        return sumaEsperada - sumaReal;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 2, 4, 5, 6};
        System.out.println("Número faltante: " + encontrarNumeroFaltante(numeros));
    }
}
