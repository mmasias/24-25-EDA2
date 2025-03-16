public class ShuntingYardLoopTest {
    private static ShuntingYardLoop calculator;
    private static int testsPassed = 0;
    private static int totalTests = 0;

    public static void main(String[] args) {
        calculator = new ShuntingYardLoop();

        testInfixToPostfix();
        testEvaluation();
        testEdgeCases();

        System.out.println("\nTest Summary:");
        System.out.println("Total tests: " + totalTests);
        System.out.println("Tests passed: " + testsPassed);
    }

    private static void testInfixToPostfix() {
        System.out.println("\nTesting Infix to Postfix Conversion:");

        // Basic operations
        assertEquals("2 3 +", calculator.infixToPostfix("2 + 3"), "Basic addition");
        assertEquals("5 3 -", calculator.infixToPostfix("5 - 3"), "Basic subtraction");
        assertEquals("4 3 *", calculator.infixToPostfix("4 * 3"), "Basic multiplication");
        assertEquals("8 2 /", calculator.infixToPostfix("8 / 2"), "Basic division");
        assertEquals("2 3 ^", calculator.infixToPostfix("2 ^ 3"), "Basic exponentiation");

        // Operator precedence
        assertEquals("3 4 2 * +", calculator.infixToPostfix("3 + 4 * 2"), "Operator precedence");
        assertEquals("3 4 + 2 *", calculator.infixToPostfix("( 3 + 4 ) * 2"), "Parentheses precedence");
    }

    private static void testEvaluation() {
        System.out.println("\nTesting Expression Evaluation:");

        // Basic operations
        assertEquals(5.0, calculator.evaluate("2 + 3"), "Basic addition");
        assertEquals(2.0, calculator.evaluate("5 - 3"), "Basic subtraction");
        assertEquals(12.0, calculator.evaluate("4 * 3"), "Basic multiplication");
        assertEquals(4.0, calculator.evaluate("8 / 2"), "Basic division");
        assertEquals(8.0, calculator.evaluate("2 ^ 3"), "Basic exponentiation");

        // Complex expressions
        assertEquals(11.0, calculator.evaluate("3 + 4 * 2"), "Complex expression 1");
        assertEquals(14.0, calculator.evaluate("( 3 + 4 ) * 2"), "Complex expression 2");
        assertEquals(3.5, calculator.evaluate("3 + 4 * 2 / ( 1 - 5 ) ^ 2"), "Complex expression 3");
    }

    private static void testEdgeCases() {
        System.out.println("\nTesting Edge Cases:");

        // Single values
        assertEquals("42", calculator.infixToPostfix("42"), "Single number conversion");
        assertEquals(42.0, calculator.evaluate("42"), "Single number evaluation");

        // Negative numbers and decimals
        assertEquals(1.0, calculator.evaluate("-2 + 3"), "Negative numbers");
        assertEquals(0.25, calculator.evaluate("1 / 4"), "Decimal division");

        // Multiple parentheses
        assertEquals("1 2 + 3 4 + *",
                calculator.infixToPostfix("( 1 + 2 ) * ( 3 + 4 )"),
                "Multiple parentheses");
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

    private static void assertEquals(double expected, double actual, String message) {
        totalTests++;
        if (Math.abs(expected - actual) < 0.0001) {
            testsPassed++;
            System.out.println("✓ " + message);
        } else {
            System.out.println("✗ " + message);
            System.out.println("  Expected: " + expected);
            System.out.println("  Actual: " + actual);
        }
    }
}