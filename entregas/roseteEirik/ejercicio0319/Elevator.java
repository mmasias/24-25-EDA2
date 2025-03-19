package ejercicio0319;

class Elevator {

    private int currentFloor;
    private int targetFloor;

    public Elevator(int currentFloor){
        this.currentFloor = currentFloor;
    }

    public void setTargetFloor(int targetFloor){
        this.targetFloor = targetFloor;
    }

    public void moves(){
        
        if (currentFloor == targetFloor) {
            System.out.println("Haz llegado a tu destino. Piso: " + currentFloor);
            return;
        }

        currentFloor += currentFloor < targetFloor ? goingUp() : goingDown();;
        
        System.out.println("Piso actual: " + currentFloor);
        
        moves();
    }

    private int goingUp(){
        return 1;
    }

    private int goingDown(){
        return -1;
    }

}