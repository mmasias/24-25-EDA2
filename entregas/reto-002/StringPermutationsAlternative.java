public class StringPermutationsAlternative {

    public static void main(String[] args) {
        String input = "abc";
        String[] result = generatePermutations(input);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print("\"" + result[i] + "\"");
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static String[] generatePermutations(String input) {
        if (input == null)
            return new String[0];

        int n = factorial(input.length());
        String[] result = new String[n];

        if (input.length() == 0) {
            result[0] = "";
            return result;
        }

        if (input.length() == 1) {
            result[0] = input;
            return result;
        }

        char first = input.charAt(0);
        String[] subPermutations = generatePermutations(input.substring(1));

        int index = 0;
        for (String subPerm : subPermutations) {
            for (int i = 0; i <= subPerm.length(); i++) {
                result[index++] = subPerm.substring(0, i) + first + subPerm.substring(i);
            }
        }

        return result;
    }

    private static int factorial(int n) {
        if (n <= 1)
            return 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}