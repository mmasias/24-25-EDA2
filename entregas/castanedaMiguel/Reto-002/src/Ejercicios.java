public class Ejercicios {



    public void sumaObjetivo(int [] entrada, int objetivo){
        int salida=0;
        boolean suma=false;
        for(int i=0;i< entrada.length &&!suma;i++){
            for(int j=0; j<entrada.length &&!suma;j++){
                if(entrada[i]+entrada[j]==objetivo && i!=j){
                    System.out.println("índices ["+i+","+j+"] ("+entrada[i]+"+"+entrada[j]+"="+objetivo+")");
                    suma=true;

                }

            }
        }
        if(!suma){
            System.out.println("No se encontró la suma adecuada");
        }
    }


    public void busquedaPalabra(char[] entrada, String palabra){

        char[] resultado=new char[palabra.length()];
        int indice=0;

        for(int i=0;i<entrada.length && indice<resultado.length;i++){
            if(palabra.charAt(indice)==entrada[i]){
                resultado[indice]=entrada[i];
                indice++;
                i=-1;
            }

        }

        if(indice==resultado.length){
            System.out.println("acierto");
        }else{
            System.out.println("fallo");
        }
    }



    public void numeroFaltante(int[] entrada){

        for(int i=0;i<entrada.length-1;i++){
            if(entrada[i]!=entrada[i+1]-1){
                System.out.println(entrada[i+1]-1);
            }
        }
    }


    public boolean montana(int[] entrada){
        boolean crece=true;

        boolean montana=true;
        for(int i=0; i< entrada.length-1 && montana;i++){
            if(crece){
                if(entrada[i]>entrada[i+1]){
                    crece=false;
                }
            }else{
                if(entrada[i]<entrada[i+1]){
                    montana=false;
                }
            }

        }

        return montana;

    }



    public void puntoEquilibrio(int[] entrada){




    }

    public int elementoMayoritario(int[] entrada){
        int actual=0;
        int veces= 1;

        for(int i=0;i<entrada.length;i++){
            if(entrada[i]!=actual){
                actual=entrada[i];
                veces=1;
            }else{
                veces++;
                if(veces>= entrada.length/2){
                    return actual;

                }
            }

        }

        return -1;


    }


    public int productoDefectuoso(boolean[] entrada){

        for(int i=0; i<entrada.length;i++){

            if(entrada[i]!=entrada[i+1]){
                return i+1;
            }

        }
        return -1;
    }

    public int rotado(int[] entrada){


        boolean crece=false;
        for(int i=0; i< entrada.length-1;i++){
            if(entrada[i]<entrada[i+1]){
                crece=true;

            }
            if(crece){
                if(entrada[i]>entrada[i+1]){
                    return i+1;
                }
            }else{
                if(entrada[i]<entrada[i+1]){
                    return i+1;
                }
            }

        }

        return -1;


    }


    public int picoMontana(int[] entrada){
        boolean crece=true;
        for(int i=0; i< entrada.length-1 ;i++){
            if(crece) {
                if (entrada[i] > entrada[i + 1]) {
                    return entrada[i];
                }
            }
        }
        return -1;
    }

    public int elementoUnico(int[] entrada){
        int [] entradaOrdenada=new int[entrada.length];

        return 0;

    }

    public int[] combinacionArrays(int[][] entrada){

        int[][] newArrays = new int[entrada.length][];

        for(int i=0;i<entrada.length;i++){
            for(int j=0; j<entrada[i].length;i++){

            }
        }

        int[] salida={1};
        return salida;
    }


    public int[] kElementosMasCercanos(int[] entrada, int elementos, int numero){
        for(int i=0;i<entrada.length;i++){

        }

        return entrada;
    }


    public static int[] findClosestElements(int[] arr, int k, double target) {
        int left = 0, right = arr.length - 1;

        // Búsqueda binaria para encontrar los k elementos más cercanos
        while (right - left >= k) {
            if (Math.abs(arr[left] - target) > Math.abs(arr[right] - target)) {
                left++;
            } else {
                right--;
            }
        }

        // Crear el array de resultados
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[left + i];
        }

        return result;
    }


    public int[] casiOrdenado(int[] entrada, int k){


        for (int x = 0; x < entrada.length; x++) {
            for (int i = 0; i < entrada.length-x-1; i++) {
                for(int j=0;j<4;j++){
                    if(entrada[i] > entrada[i+1]) {
                        int tmp = entrada[i + 1];
                        entrada[i + 1] = entrada[i];
                        entrada[i] = tmp;
                    }
                }
            }
        }


        return entrada;
    }






}


