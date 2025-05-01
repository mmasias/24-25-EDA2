package propuesta;

public class Indice {
    private String[] valores;
    private int[][] posiciones;
    private int[] contadores;
    private int cantidadValores;

    public Indice(int capacidadMaxima) {
        valores = new String[capacidadMaxima];
        posiciones = new int[capacidadMaxima][capacidadMaxima];
        contadores = new int[capacidadMaxima];
        cantidadValores = 0;
    }

    public void agregar(String valor, int posicion) {
      
        int indiceValor = buscarPosicionOrdenada(valor);
        
        if (indiceValor == -1) {
            
            indiceValor = encontrarPosicionInsercion(valor);
            
           
            for (int i = cantidadValores; i > indiceValor; i--) {
                valores[i] = valores[i - 1];
                contadores[i] = contadores[i - 1];
                
                
                for (int j = 0; j < contadores[i - 1]; j++) {
                    posiciones[i][j] = posiciones[i - 1][j];
                }
            }
            
            
            valores[indiceValor] = valor;
            contadores[indiceValor] = 0;
            cantidadValores++;
        }

       
        posiciones[indiceValor][contadores[indiceValor]] = posicion;
        contadores[indiceValor]++;
    }

    
    private int encontrarPosicionInsercion(String valor) {
        
        if (cantidadValores == 0) {
            return 0;
        }
        
        
        for (int i = 0; i < cantidadValores; i++) {
            if (valor.compareTo(valores[i]) < 0) {
                return i;
            }
        }
        
       
        return cantidadValores;
    }

    
    private int buscarPosicionOrdenada(String valor) {
       
        int inicio = 0;
        int fin = cantidadValores - 1;
        
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = valor.compareTo(valores[medio]);
            
            if (comparacion == 0) {
                return medio; 
            } else if (comparacion < 0) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }
        
        return -1; 
    }

    public int[] buscar(String valor) {
        int indiceValor = buscarPosicionOrdenada(valor);
        
        if (indiceValor == -1) {
            return new int[0]; 
        }

        int[] resultado = new int[contadores[indiceValor]];
        for (int i = 0; i < contadores[indiceValor]; i++) {
            resultado[i] = posiciones[indiceValor][i];
        }

        return resultado;
    }

    public boolean contiene(String valor) {
        return buscarPosicionOrdenada(valor) != -1;
    }

    public String[] obtenerTodos() {
        String[] resultado = new String[cantidadValores];
        for (int i = 0; i < cantidadValores; i++) {
            resultado[i] = valores[i];
        }
        return resultado;
    }
}