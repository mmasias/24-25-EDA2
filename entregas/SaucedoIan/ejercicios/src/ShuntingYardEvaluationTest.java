public class ShuntingYardEvaluationTest {
    private static ShuntingYardRecursive calculator;
    private static int testsPassed = 0;
    private static int totalTests = 0;

    public static void main(String[] args) {
        calculator = new ShuntingYardRecursive();

        testBasicOperations();
        testComplexExpressions();
        testEdgeCases();
        testPrecedence();

        System.out.println("\nEvaluation Tests Summary:");
        System.out.println("Total tests: " + totalTests);
        System.out.println("Tests passed: " + testsPassed);
    }

    private static void testBasicOperations() {
        assertEquals(5.0, calculator.evaluate("2 + 3"), "Basic addition");
        assertEquals(2.0, calculator.evaluate("5 - 3"), "Basic subtraction");
        assertEquals(12.0, calculator.evaluate("4 * 3"), "Basic multiplication");
        assertEquals(4.0, calculator.evaluate("8 / 2"), "Basic division");
        assertEquals(8.0, calculator.evaluate("2 ^ 3"), "Basic exponentiation");
    }

    private static void testComplexExpressions() {
        assertEquals(11.0, calculator.evaluate("3 + 4 * 2"), "Complex expression 1");
        assertEquals(14.0, calculator.evaluate("( 3 + 4 ) * 2"), "Complex expression 2");
        assertEquals(3.5, calculator.evaluate("3 + 4 * 2 / ( 1 - 5 ) ^ 2"), "Complex expression 3");
    }

    private static void testEdgeCases() {
        assertEquals(42.0, calculator.evaluate("42"), "Single number");
        assertEquals(-5.0, calculator.evaluate("0 - 5"), "Negative result");
        assertEquals(0.25, calculator.evaluate("1 / 4"), "Decimal result");
    }

    private static void testPrecedence() {
        assertEquals(21.0, calculator.evaluate("( 1 + 2 ) * ( 3 + 4 )"), "Parentheses precedence");
        assertEquals(14.0, calculator.evaluate("2 + 3 * 4"), "Operator precedence");
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