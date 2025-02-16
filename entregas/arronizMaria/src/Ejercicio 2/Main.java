class Main {
    public static void main(String[] args) {
        Frame frame1 = new Frame(4, 4);
        Frame frame2= new Frame(4, 4);
        Screen screen = new Screen(frame1,frame2);

        screen.print(); 
    }
}
