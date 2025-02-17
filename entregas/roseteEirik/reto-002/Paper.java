class Paper extends Element {
    @Override
    public String fightAgainst(Element opponent){
        return opponent.faceAgainst(this);
    }

    @Override
    public String faceAgainst(Rock rock){
        return "You win against Rock!";
    }

    @Override
    public String faceAgainst(Paper paper){
        return "It's a tie!";
    }

    @Override
    public String faceAgainst(Scissors scissors){
        return "You lose against Scissors!";
    }

    @Override
    public String getName(){
        return "Paper";
    }
}