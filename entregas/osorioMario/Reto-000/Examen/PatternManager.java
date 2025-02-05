public class PatternManager {
    private String[][] patterns = {
        {"Negro", "Blanco"},
        {"Cyan", "Magenta"}
    };
    private int currentPattern = 0;

    public void switchPattern() {
        currentPattern = (currentPattern + 1) % patterns.length;
    }

    public String[][] getCurrentPattern() {
        return patterns;
    }
}
