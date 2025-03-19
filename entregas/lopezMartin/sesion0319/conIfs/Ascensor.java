package entregas.lopezMartin.sesion0319.conIfs;

import java.util.Scanner;

public class Ascensor {
    private int plantaActual;

    public Ascensor(int plantaInicial) {
        this.plantaActual = plantaInicial;
    }

    public void moverAscensor(int plantaDestino) {
        if (plantaActual == plantaDestino) {
            System.out.println("El ascensor ha llegado a la planta " + plantaDestino);
            return;
        }
        
        if (plantaActual < plantaDestino) {
            System.out.println("Subiendo a la planta " + (plantaActual + 1));
            plantaActual++;
        } else {
            System.out.println("Bajando a la planta " + (plantaActual - 1));
            plantaActual--;
        }
        
        moverAscensor(plantaDestino);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ascensor ascensor = new Ascensor(0);

        boolean activo = true;

        while(activo){

            System.out.println("Introduce la planta destino: ");
            int plantaDestino = scanner.nextInt();
            scanner.nextLine();
            ascensor.moverAscensor(plantaDestino);

            System.out.println("¿Quieres seguir usando el ascensor? (SI O NO)");
            String respuesta = scanner.nextLine().toUpperCase();
            switch (respuesta) {
                case "SI":
                    activo= true;
                    break;
            
                case "NO":
                    activo = false;
                    break;

                default:
                    System.out.println("Entrada no valida");
            }

        }
           
    }
}