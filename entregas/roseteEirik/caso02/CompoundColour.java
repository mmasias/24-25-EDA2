package entregas.roseteEirik.caso02;

public class CompoundColour {
    
    private String colour;
    private String colour2;
    
    public CompoundColour(String colour, String colour2) {
        this.colour = colour;
        this.colour2 = colour2;
    }
    
    public String mixColours(String colour, String colour2) {
        return colour + " " + colour2;
    }

}
