import java.util.ArrayList;
import java.util.List;

public class InstructionCreator {
    private static final int FRAME_WIDTH = 20;
    private static final int TOTAL_WIDTH = FRAME_WIDTH * 2;
    private static final int STAR_POINTS = 5;
    private static final double INNER_RATIO = 0.4;

    public List<List<Instruction>> createInstructions(int totalRows, int totalCols, int frames, int refreshRate, char[] colors) {
        List<List<Instruction>> allInstructions = new ArrayList<>();
        int centerY = totalRows / 2;
        int centerX = FRAME_WIDTH / 2;

        int minRadius = 2;
        int maxRadius = Math.min(totalRows, FRAME_WIDTH) / 3;

        for (int frame = 0; frame < frames; frame++) {
            List<Instruction> instructions = new ArrayList<>();
            char currentColor = colors[frame % colors.length];

            double rotation = 2 * Math.PI * frame / frames;
            double oscillation = Math.sin((double) frame / frames * 2 * Math.PI);
            int radius = (int) ((maxRadius - minRadius) / 2 * (oscillation + 1) + minRadius);

            for (int y = 0; y < totalRows; y++) {
                for (int x = 0; x < TOTAL_WIDTH; x++) {
                    boolean isRightFrame = x >= FRAME_WIDTH;
                    int frameX = isRightFrame ? x - FRAME_WIDTH : x;

                    double angle = Math.atan2(y - centerY, frameX - centerX) - rotation;
                    double distance = Math.sqrt((frameX - centerX) * (frameX - centerX) + (y - centerY) * (y - centerY));

                    double starRadius = radius * (1 + Math.cos(STAR_POINTS * angle) * INNER_RATIO);

                    char pixelChar = ' ';
                    String colorCode = "n";

                    if (distance <= starRadius) {
                        pixelChar = currentColor;
                        switch (currentColor) {
                            case '.':
                                colorCode = "n";
                                break;
                            case '#':
                                colorCode = "b";
                                break;
                            case '+':
                                colorCode = "c";
                                break;
                            case '*':
                                colorCode = "m";
                                break;
                            default:
                                colorCode = "n";
                                break;
                        }
                    }

                    Pixel pixel = new Pixel();
                    pixel.setAsciiValue(String.valueOf(pixelChar));
                    pixel.setColor(colorCode);

                    Instruction instr = new Instruction();
                    instr.createInstruction(pixel, frameX, y);
                    instructions.add(instr);
                }
            }
            allInstructions.add(instructions);
        }
        return allInstructions;
    }
}