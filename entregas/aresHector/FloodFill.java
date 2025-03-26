public class FloodFill {
    public static void main(String[] args) {
        char[][] matrix = {
            "''''''''''''''''''''''''''''''''''''''''''''''''''".toCharArray(),
            "''''''''''''''''''''''''''''''''''''''''''''''''''".toCharArray(),
            "''########''''''''#########'''''''########''''''''".toCharArray(),
            "''#......#''''''''#.......#'''''''#.......#''''''".toCharArray(),
            "''#......#''''''''#.......#'''''''#.......#''''''".toCharArray(),
            "''#......#''''''''#.......#'''''''#.......#''''''".toCharArray(),
            "''########''''''''#########'''''''########''''''''".toCharArray(),
            "''''''''''''''''''''''''''''''''''''''''''''''''''".toCharArray(),
            "''########''''########''''########''''########''''".toCharArray(),
            "''#......#''''#......#''''#......#''''#......#''''".toCharArray(),
            "''#......#''''#......#''''#......#''''#......#''''".toCharArray(),
            "''########''''########''''########''''########''''".toCharArray(),
            "''''''''''''''''''''''''''''''''''''''''''''''''''".toCharArray(),
            "''#######'''''''''#######'''''''''#######''''''''".toCharArray(),
            "''#.....#'''''''''#.....#'''''''''#.....#''''''''".toCharArray(),
            "''#.....#'''''''''#.....#'''''''''#.....#''''''''".toCharArray(),
            "''#######'''''''''#######'''''''''#######''''''''".toCharArray(),
            "''''''''''''''''''''''''''''''''''''''''''''''''''".toCharArray(),
            "''''''''''''''''''''''''''''''''''''''''''''''''''".toCharArray(),
            "''''''''''''''''''''''''''''''''''''''''''''''''''".toCharArray(),
        };

        floodFill(matrix, 3, 3, '.', 'o');  
        floodFill(matrix, 3, 19, '.', 'o');  
        floodFill(matrix, 3, 32, '.', 'o');  

        floodFill(matrix, 9, 3, '.', 'x');  
        floodFill(matrix, 9, 14, '.', 'x');  
        floodFill(matrix, 9, 26, '.', 'x');  
        floodFill(matrix, 9, 38, '.', 'x');  

        floodFill(matrix, 14, 3, '.', '|');  
        floodFill(matrix, 14, 14, '.', '|');  
        floodFill(matrix, 14, 26, '.', '|');  

        printMatrix(matrix);
    }

    public static void floodFill(char[][] matrix, int x, int y, char target, char replacement) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return;
        if (matrix[x][y] != target) return;

        matrix[x][y] = replacement;

        floodFill(matrix, x + 1, y, target, replacement);
        floodFill(matrix, x - 1, y, target, replacement);
        floodFill(matrix, x, y + 1, target, replacement);
        floodFill(matrix, x, y - 1, target, replacement);
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(new String(row));
        }
    }
}

