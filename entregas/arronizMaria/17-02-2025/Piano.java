class Piano extends Instrumento  implements Afinar{
    @Override
    public void tocar(){
        System.out.println("do re mi fa sol");
    }

    public void sonata(){
        System.out.println("sol# do# mi, la re# fa#");
    }

    public String afinar(){
        return "Done";
    }
}