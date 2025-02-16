class BufferDoble {
    private Frame frame1;
    private Frame frame2;
    private boolean alternar;
    
    public BufferDoble() {
        frame1 = new Frame();
        frame2 = new Frame();
        alternar = true;
    }
    
    public Frame getFrameActivo() {
        return alternar ? frame1 : frame2;
    }
    
    public Frame getFrameInactivo() {
        return alternar ? frame2 : frame1;
    }
    
    public void alternarFrame() {
        alternar = !alternar;
    }
}
