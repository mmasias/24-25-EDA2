package ejercicio0319;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the current floor: ");
        int currentFloor = scanner.nextInt();
        Elevator elevator = new Elevator(currentFloor);

        System.out.print("Enter the target floor: ");
        int targetFloor = scanner.nextInt();
        elevator.setTargetFloor(targetFloor);

        elevator.moves();
    }
}
