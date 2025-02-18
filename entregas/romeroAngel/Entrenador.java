import java.util.Random;
import java.util.Scanner;

public class Entrenador {
    private Pokemon pokemon;

    public Entrenador(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    public void entrenar(int sesiones) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("" + pokemon.getNombre() + " esta listo para entrenar! Presiona Enter para empezar.");
        scanner.nextLine();

        for(int i = 0;i<sesiones;i++){
            ordernarAccionAleatoria();
            
            Thread.sleep(2000 + new Random().nextInt(1000));
        }

        System.out.println("¡Entrenamiento de " + pokemon.getNombre() + " terminado!");
    }

    public void ordernarAccionAleatoria() throws InterruptedException{
        Random random = new Random();
        int accion = random.nextInt(3);

        if(accion == 0){
            System.out.println("\n¡" + pokemon.getNombre() + " ataca!");
            pokemon.atacar();
        } else if (accion == 1) {
            System.out.println("\n¡" + pokemon.getNombre() + " gana experiencia y sube de nivel!");
            pokemon = pokemon.subirNivel();
        } else {
            System.out.println(" \n" + pokemon.getNombre() + " descansa...");
        }

        Thread.sleep(2000 + random.nextInt(1000));
    }

    public void cambiarPokemon(Pokemon nuevoPokemon){
        System.out.println("Fuera " + pokemon.getNombre() + "! Vamos, " + nuevoPokemon.getNombre() + "!");
        this.pokemon = nuevoPokemon;
        this.pokemon.mosrarInfo();
    }
}
