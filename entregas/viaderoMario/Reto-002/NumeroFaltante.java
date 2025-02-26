public class NumeroFaltante {
        public static void main(String[] args) {
            int[] array = {1, 2, 4, 5, 6}; 
            int n = array.length + 1;
    
            int numeroFaltante = encontrarNumeroFaltante(array, n);
            System.out.println("El número faltante es: " + numeroFaltante);
        }
    
        public static int encontrarNumeroFaltante(int[] array, int n) {
            int sumaEsperada = n * (n + 1) / 2;
            int sumaActual = 0;
    
            for (int num : array) {
                sumaActual += num;
            }
    
            return sumaEsperada - sumaActual;
        }
    
    
}
