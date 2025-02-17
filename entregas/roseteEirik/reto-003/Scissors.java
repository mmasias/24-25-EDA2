class Scissors extends Element {
    @Override
    public String fightAgainst(Element opponent){
        return opponent.faceAgainst(this);
    }

    @Override
    public String faceAgainst(Rock rock){
        return "You lose against Rock!";
    }

    @Override
    public String faceAgainst(Paper paper){
        return "You win against Paper!";
    }

    @Override
    public String faceAgainst(Scissors scissors){
        return "It's a tie!";
    }

    @Override
    public String getName(){
        return "Scissors";
    }
}