public class Pixel{

    private char numeral;
    private char punto;
    private char mas;

    public Pixel(char numeral, char punto, char mas){
        this.numeral = numeral;
        this.punto = punto;
        this.mas = mas;
    }

    public char getNumeral(){
        return this.numeral;
    }
    
    public char getPunto(){
        return this.punto;
    }
    
    public char getMas(){
        return this.mas;
    }
    

}