
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
    if (destinationFloor > this.currentFloor) {
      this.currentFloor++;
      System.out.println("Subiendo a" + this.currentFloor);
      moveLift(destinationFloor);
    } else if (destinationFloor < this.currentFloor) {
      this.currentFloor--;
      System.out.println("Bajando a " + this.currentFloor);
      moveLift(destinationFloor);
    } else {
      System.out.println("se ha llegado a " + this.currentFloor);
      this.destinationFloor = this.currentFloor;
      return;
    }
  }

  public static void main(String[] args) {
    Lift lift = new Lift(5);
    lift.moveLift(4);
  }
}
