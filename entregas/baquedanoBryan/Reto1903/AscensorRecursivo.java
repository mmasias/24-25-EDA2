package entregas.baquedanoBryan.Reto1903;

public class AscensorRecursivo {
    
    private int plantaActual;
    private int plantaDestino;
    private int dirección;
    private boolean estado;


    public AscensorRecursivo(int plantaActual, int plantaDestino) {
        this.plantaActual = plantaActual;
        this.plantaDestino = plantaDestino;  
        this.dirección = calculoDirección();  
        this.estado = true;   
    }

    
    public void moverse() {
        if (plantaActual == plantaDestino) {
            detenerse(); 
            return;
        }

        System.out.println("Estoy en el piso" + plantaActual);
    
        if (calculoDirección()>0) {
            plantaActual++; 
            System.out.println("Subiendo al piso " + plantaActual);
        } else {
            plantaActual--; 
            System.out.println("Bajando al piso " + plantaActual);
        }
    
        moverse();
    }


    public void detenerse() {
        estado = false;
        System.out.println("Ascensor detenido en el piso " + plantaActual);
    }

    public int calculoDirección() {
        return Integer.compare(plantaDestino, plantaActual);
    }

    

    
    public static void main(String[] args) {
        AscensorRecursivo ascensor = new AscensorRecursivo(0, 5);
        ascensor.moverse();
    }
}
