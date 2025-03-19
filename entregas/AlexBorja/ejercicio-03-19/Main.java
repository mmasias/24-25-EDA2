class Main {
   public static void main(String[] args) {
      Elevator elevator = new Elevator();

      elevator.show();

      elevator.move(10);
      elevator.show();

      elevator.move(-2);
      elevator.show();
   }
}
