public class Main {
    public static void main(String[] args) {
        
        Elements[] elements = {new Rock(), new Paper(), new Scissors()};

        int random1 = (int)(Math.random() * 3);
        int random2 = (int)(Math.random() * 3);
        
        Element player1 = elements[random1];
        Element palyer2 = elements[random2];

        System.out.println("Player 1: " + player1.getName() + "vs" + "Player 2: " + player2.getName());
        System.out.println(player1.fightAgainst(player2));

    }
}