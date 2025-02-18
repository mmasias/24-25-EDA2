import java.util.Random;
import java.util.Scanner;

public class Entrenador {
    private Pokemon pokemon;

    public Entrenador(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    public void entrenar(int sesiones) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡" + pokemon.getNombre() + " esta listo para entrenar! Presiona Enter para empezar.");
        scanner.nextLine();

        for(int i = 0;i<sesiones;i++){
            ordernarAccionAleatoria();
            
            Thread.sleep(2000 + new Random().nextInt(1000));
        }
    }

    public void ordernarAccionAleatoria(){
    }

    public void cambiarPokemon(Pokemon pokemon){
    }
}
