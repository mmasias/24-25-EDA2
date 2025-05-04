public class IndiceOrdenado {

    private String[] valores;
    private int[][] posiciones;
    private int[] contadores;
    private int cantidadValores;
    public IndiceOrdenado(int capacidadMaxima) {
        valores = new String[capacidadMaxima];
        posiciones = new int[capacidadMaxima][capacidadMaxima];
        contadores = new int[capacidadMaxima];
        cantidadValores = 0;
    }


    public void agregar(String valor, int posicion){
        int indiceValor=buscarPosicionValor(valor);

        String temp;
        int tempInt;

        if(indiceValor >= 0){
            posiciones[indiceValor][contadores[indiceValor]]= cantidadValores;
            contadores[indiceValor]++;
        }else{
            valores[cantidadValores]=valor;
            posiciones[cantidadValores][0]=cantidadValores;
            contadores[cantidadValores]=1;



            for(int i=cantidadValores;i>0;i--){
                for (int j = cantidadValores-1; j >= 0; j--) { // j es el índice para comparar elementos adyacentes
                    if (compararString(valores[j],valores[j+1])==-1 ) {
                        temp = valores[j];
                        valores[j] = valores[j +1];
                        valores[j + 1] = temp;

                        moverFila(posiciones,j,i);

                        tempInt = contadores[j];
                        contadores[j] = contadores[j +1];
                        contadores[j + 1] = tempInt;
                    }else{
                        i=0;
                        j=0;
                    }
                }
            }
            cantidadValores++;

        }
    }

    public int buscarPosicionValor(String valor){

        int indiceValor = -1;
        int i = 0;

        while (i < cantidadValores && indiceValor == -1) {
            if (valores[i].equals(valor)) {
                indiceValor = i;
            }
            i++;
        }

        return indiceValor;
    }




    public int[] buscar(String valor) {
        int indiceValor = -1;
        int posicion = 0;

        while (posicion < cantidadValores && indiceValor == -1) {
            if (valores[posicion].equals(valor)) {
                indiceValor = posicion;
            }
            posicion++;
        }

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
        for (int i = 0; i < cantidadValores; i++) {
            if (valores[i].equals(valor)) {
                return true;
            }
        }
        return false;
    }

    public String[] obtenerTodos() {
        String[] resultado = new String[cantidadValores];
        for (int i = 0; i < cantidadValores; i++) {
            resultado[i] = valores[i];
        }
        return resultado;
    }


    public int compararString(String palabra1, String palabra2){
        int long1=palabra1.length();
        int long2=palabra2.length();

        int resultado=0;
        for(int i=0;i<palabra1.length();i++) {
            resultado=compararChar(palabra1.charAt(i), palabra2.charAt(i));
            if(resultado!=0){
                return resultado;
            }
        }

        return resultado;


    }

    public int compararChar(char letra1, char letra2){
        if(mirar2(letra1)<mirar2(letra2)){
            return 1;
        }
        if(mirar2(letra1)>mirar2(letra2)){
            return -1;
        }
        return 0;

    }

    public int mirar2(char valor) {

        if (valor >= '0' && valor <= '9') {
            return valor - '0';
        }

        valor = Character.toLowerCase(valor);

        if (valor >= 'a' && valor <= 'z') {
            return 10 + (valor - 'a');
        }

        return -1;
    }

    public static void moverFila(int[][] matriz, int filaOrigen, int filaDestino) {
        if (filaOrigen < 0 || filaOrigen >= matriz.length || filaDestino < 0 || filaDestino >= matriz.length) {
            throw new IllegalArgumentException("Índices fuera de rango");
        }

        int[] temp = matriz[filaOrigen];

        if (filaOrigen < filaDestino) {
            for (int i = filaOrigen; i < filaDestino; i++) {
                matriz[i] = matriz[i + 1];
            }
        } else if (filaOrigen > filaDestino) {
            for (int i = filaOrigen; i > filaDestino; i--) {
                matriz[i] = matriz[i - 1];
            }
        }

        matriz[filaDestino] = temp;
    }




}
