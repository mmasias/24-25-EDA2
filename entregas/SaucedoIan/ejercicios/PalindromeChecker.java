import java.util.Scanner;

public class PalindromeChecker {
  public static boolean isPalindrome(String text) {
    return text == null || text.length() <= 1 ? true
        : text.charAt(0) != text.charAt(text.length() - 1) ? false : isPalindrome(text.substring(1, text.length() - 1));
  }

  public static String cleanText(String input) {
    return input.toLowerCase().replaceAll("[^a-z]", "");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter text to check (or 'exit' to quit):");

    while (true) {
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("exit"))
        break;

      String cleaned = cleanText(input);
      System.out.printf("'%s' is %sa palindrome%n",
          input,
          isPalindrome(cleaned) ? "" : "not ");
    }
    scanner.close();
  }
}