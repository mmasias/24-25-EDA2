public class ShuntingYardConversionTest {
    private static ShuntingYardRecursive calculator;
    private static int testsPassed = 0;
    private static int totalTests = 0;

    public static void main(String[] args) {
        calculator = new ShuntingYardRecursive();

        testSingleNumberConversion();
        testBasicOperations();
        testOperatorPrecedence();
        testParentheses();
        testComplexExpressions();

        System.out.println("\nConversion Tests Summary:");
        System.out.println("Total tests: " + totalTests);
        System.out.println("Tests passed: " + testsPassed);
    }

    private static void testSingleNumberConversion() {
        assertEquals("42", calculator.infixToPostfix("42"), "Single number conversion");
    }

    private static void testBasicOperations() {
        assertEquals("2 3 +", calculator.infixToPostfix("2 + 3"), "Basic addition");
        assertEquals("5 3 -", calculator.infixToPostfix("5 - 3"), "Basic subtraction");
        assertEquals("4 3 *", calculator.infixToPostfix("4 * 3"), "Basic multiplication");
        assertEquals("8 2 /", calculator.infixToPostfix("8 / 2"), "Basic division");
        assertEquals("2 3 ^", calculator.infixToPostfix("2 ^ 3"), "Basic exponentiation");
    }

    private static void testOperatorPrecedence() {
        assertEquals("3 4 2 * +", calculator.infixToPostfix("3 + 4 * 2"), "Operator precedence test 1");
        assertEquals("1 2 + 3 4 + *", calculator.infixToPostfix("( 1 + 2 ) * ( 3 + 4 )"), "Operator precedence test 2");
    }

    private static void testParentheses() {
        assertEquals("3 4 + 2 *", calculator.infixToPostfix("( 3 + 4 ) * 2"), "Simple parentheses");
        assertEquals("3 4 2 * + 1 -", calculator.infixToPostfix("3 + 4 * 2 - 1"), "Complex parentheses");
    }

    private static void testComplexExpressions() {
        assertEquals("3 4 2 * 1 5 - 2 ^ / +",
                calculator.infixToPostfix("3 + 4 * 2 / ( 1 - 5 ) ^ 2"),
                "Complex expression");
    }

    private static void assertEquals(String expected, String actual, String message) {
        totalTests++;
        if (expected.equals(actual)) {
            testsPassed++;
            System.out.println("✓ " + message);
        } else {
            System.out.println("✗ " + message);
            System.out.println("  Expected: " + expected);
            System.out.println("  Actual: " + actual);
        }
    }
}