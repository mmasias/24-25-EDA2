class Screen {
    private Frame frame1;
    private Frame frame2;

    public Screen(Frame frame1, Frame frame2){
        this.frame1=frame1;
        this.frame2=frame2;
    }

    public Frame combine(){
        Frame result = new Frame(frame1.getWidth(),frame1.getHeight());

        for (int x = 0; x < frame1.getHeight(); x++) {
            for (int y = 0; y < frame1.getWidth(); y++) {
                int sum = frame1.getPixel(x, y).getValue() + frame2.getPixel(x, y).getValue();
                result.setPixel(x, y, sum);
            }
        }
        return result;
    }

    public void print(){
        combine().printFrame();
    }

}
