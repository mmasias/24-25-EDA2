class Elevator {
   private int currentFloor = 0;
   private int topFloor = 5;
   private int bottomFloor = -2;
   private int stop = 0;

   public void move(int floor) {
      if (floor == currentFloor || stop == 1)
         return;

      if (floor > currentFloor && (currentFloor + 1) <= topFloor) {
         currentFloor++;
      } else if (floor < currentFloor && (currentFloor - 1) >= bottomFloor) {
         currentFloor--;
      } else {
         stop = 1;
      }

      move(floor);
   }

   public void show() {
      System.out.println("Current floor: " + currentFloor);
   }
}
