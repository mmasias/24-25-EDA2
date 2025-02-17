class Rock extends Element {
    @Override
    public String fightAgainst(Element opponent){
        return opponent.faceAgainst(this);
    }

    @Override
    public String faceAgainst(Rock rock){
        return "It's a tie!";
    }

    @Override
    public String faceAgainst(Paper paper){
        return "You lose against Paper!";
    }

    @Override
    public String faceAgainst(Scissors scissors){
        return "You win against Scissors!";
    }

    @Override
    public String getName(){
        return "Rock";
    }
}