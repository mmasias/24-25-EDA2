package entregas.PinedaOscar.Reto_005;

public class Consola {

    public static void limpiarPantalla(){
        System.out.print("\033[0;0H\033[0;0J");
        System.out.flush();
    }

    public static void posicionarse(int fila, int columna){
        char codigoDeEscape = 0x1B;
        System.out.print(String.format("%c[%d;%df",codigoDeEscape,fila,columna));        
    }    
}