package entregas.baquedanoBryan.Reto1903;

public class AscensorRecursivo {
    
    private int plantaActual;
    private int plantaDestino;
    private boolean estado;

    // Constructor solo con planta actual
    public AscensorRecursivo(int plantaActual) {
        this.plantaActual = plantaActual;
        this.estado = true;   
    }

    // Método que mueve el ascensor hasta la planta destino
    public void moverse(int plantaDestino) {
        this.plantaDestino = plantaDestino;  // Ahora la planta destino se asigna aquí

       

        System.out.println("Estoy en el piso " + plantaActual);
    
        if (calculoDirección() > 0) {
            plantaActual++;
            System.out.println("Subiendo al piso " + plantaActual);
        } else {
            plantaActual--;
            System.out.println("Bajando al piso " + plantaActual);
        }

        moverse(plantaDestino);  // Llamada recursiva con el destino
    }

    public void detenerse() {

        if(plantaActual == plantaDestino){
            estado = false;
            System.out.println("Ascensor detenido en el piso " + plantaActual);
        }
       
    }

    public int calculoDirección() {
        return Integer.compare(plantaDestino, plantaActual);
    }


    public static void main(String[] args) {
        AscensorRecursivo ascensor = new AscensorRecursivo(1);  
        ascensor.moverse(5); 
    }
}