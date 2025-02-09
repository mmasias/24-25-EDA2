import java.util.ArrayList;
import java.util.List;

public class InstructionCreator {

    public List<List<Instruction>> createInstructions(int totalRows, int totalCols, int frames, int refreshRate,
            char[] colors) {
        List<List<Instruction>> allInstructions = new ArrayList<>();

        int centerY = totalRows / 2;
        int centerX = totalCols / 2;
        int minRadius = 2;
        int maxRadius = Math.min(totalRows, totalCols) / 1;

        for (int frame = 0; frame < frames; frame++) {
            List<Instruction> instructions = new ArrayList<>();
            RendererEngine engine = new RendererEngine(new BufferFrame());
            engine.setMode("color");

            char currentColor = colors[frame % colors.length];

            double oscillation = Math.sin((double) frame / frames * 2 * Math.PI);
            int radius = (int) ((maxRadius - minRadius) / 2 * (oscillation + 1) + minRadius);

            for (int y = 0; y < totalRows; y++) {
                for (int x = 0; x < totalCols; x++) {
                    Instruction instr = new Instruction();
                    Pixel p = new Pixel();

                    int distanceSquared = (y - centerY) * (y - centerY) + (x - centerX) * (x - centerX);
                    char pixelChar = (distanceSquared <= radius * radius) ? currentColor : ' ';

                    p.AsciiArray = String.valueOf(pixelChar);
                    instr.Color = '#';
                    boolean isExtended = (x >= 20);
                    int posX = isExtended ? x - 20 : x;
                    instr.createInstruction(p, posX, y, isExtended);
                    engine.ReceiveInstruction(instr);
                    instructions.add(instr);
                }
            }
            allInstructions.add(instructions);
        }
        return allInstructions;
    }
}