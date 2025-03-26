public class FloodFill {

    static final int ROWS = 20;
    static final int COLS = 50;

    public static void main(String[] args) {
        char[][] image = {
            ".....................................................".toCharArray(),
            ".....................................................".toCharArray(),
            "..########........#########.......########...........".toCharArray(),
            "..#......#........#.......#.......#......#...........".toCharArray(),
            "..#......#........#.......#.......#......#...........".toCharArray(),
            "..#......#........#.......#.......#......#...........".toCharArray(),
            "..########........#########.......########...........".toCharArray(),
            ".....................................................".toCharArray(),
            "..########....########....########....########.......".toCharArray(),
            "..#......#....#......#....#......#....#......#.......".toCharArray(),
            "..#......#....#......#....#......#....#......#.......".toCharArray(),
            "..########....########....########....########.......".toCharArray(),
            ".....................................................".toCharArray(),
            "..#######.........#######.........#######..........".toCharArray(),
            "..#.....#.........#.....#.........#.....#..........".toCharArray(),
            "..#.....#.........#.....#.........#.....#..........".toCharArray(),
            "..#######.........#######.........#######..........".toCharArray(),
            ".....................................................".toCharArray(),
            ".....................................................".toCharArray(),
            ".....................................................".toCharArray()
        };

        floodFill(image, 2, 2, '#', 'o');
        floodFill(image, 6, 19, '#', 'x');
        floodFill(image, 10, 18, '#', '|');
        floodFill(image, 15, 5, '#', '&');

        printImage(image);
    }

    public static void floodFill(char[][] image, int x, int y, char target, char replacement) {
        if (x < 0 || y < 0 || x >= ROWS || y >= COLS || image[x][y] != target) {
            return;
        }
        image[x][y] = replacement;
        floodFill(image, x + 1, y, target, replacement);
        floodFill(image, x - 1, y, target, replacement);
        floodFill(image, x, y + 1, target, replacement);
        floodFill(image, x, y - 1, target, replacement);
    }

    public static void printImage(char[][] image) {
        for (int i = 0; i < ROWS; i++) {
            System.out.println(image[i]);
        }
    }
}
