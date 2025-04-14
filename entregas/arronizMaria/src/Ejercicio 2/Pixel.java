class Pixel {
    private int value;
    private Coordinates coordinates;

    public Pixel(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setCordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }    

    public String translate(int value){
        String[] tiles= {"·","#","+","*","@",":",";","=","&","$"};
        return tiles[value];
    }
}
