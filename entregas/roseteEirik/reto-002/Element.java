abstract class Element {

    public abstract String fightAgainst(Element opponent);


    public abstract String faceAgainst(Rock rock);
    public abstract String faceAgainst(Paper paper);
    public abstract String faceAgainst(Scissors scissors);

    public abstract String getName();
}
