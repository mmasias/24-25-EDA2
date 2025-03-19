public class Lift {
  int destinationFloor;
  int currentFloor;

  public Lift(int currentFloor) {
    this.currentFloor = currentFloor;
  }

  public int setDestinationFloor(int destinationFloor) {
    return this.destinationFloor = destinationFloor;
  }

  public void moveLift(int destinationFloor) {
    System.out.println(currentFloor == destinationFloor ? "Llego a " + currentFloor
        : ((currentFloor = currentFloor + (currentFloor < destinationFloor ? 1 : -1)) > 0 ? "Moviendo a " + currentFloor
            : "Moviendo a" + currentFloor));

    if (currentFloor != destinationFloor)
      moveLift(destinationFloor);
  }

  public static void main(String[] args) {
    Lift lift = new Lift(-2);
    lift.moveLift(4);
  }
}