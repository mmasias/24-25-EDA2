import java.util.Scanner;

class Elevator {
    public static void main(String[] args) {
        Elevator elevator1 = new Elevator();

        int floor = 0;
        int newFloor = intro();
        elevator1.moves(floor, newFloor);
    }

    void moves(int floor, int newFloor){
        System.out.println("Estas en la planta: " + floor);

        if(newFloor == floor){
            System.out.println("Llegaste!");
            floor = newFloor;
            newFloor = intro();
            moves(floor, newFloor);
            return;
        }

        if(newFloor<floor){
            floor--;
            moves(floor, newFloor);
        }

        if(newFloor>floor){
            floor++;
            moves(floor, newFloor);
        }


    }

    @SuppressWarnings("resource")
    static int intro() {
        System.out.println("A que planta quiere ir: ");
        return new Scanner(System.in).nextInt();
    }

}
    