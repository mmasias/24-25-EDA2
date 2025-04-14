class Audicion {
    public static void main(String[] args) {
        Instrumento instrumento1 = new Instrumento();

        Instrumento instrumento2 = new Piano();
        instrumento2.tocar();
        
        Piano piano1 = new Instrumento(); //mal
        


        Instrumento instrumento3 = new Piano();
        instrumento3.tocar();
        instrumento3.sonata(); //mal
        


        Instrumento[] instrumentos = new Piano[3];
        instrumentos[0] = new Piano();
        instrumentos[1] = new Instrumento(); //mal
        
        Instrumento[] instrumentosOK = new Instrumento[3];
        instrumentos[0] = new Piano();
        instrumentos[1] = new Instrumento();
        

        
        Piano piano2 = new Piano();
        Instrumento instrumento4 = piano2;
        System.out.println(piano2.equals(instrumento4));



        Piano piano3 = new Piano();
        System.out.println(piano3.afinar());
    }

}
