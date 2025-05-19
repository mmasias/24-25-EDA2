public class StudentHasher {

    private static final int P = 31;
    private static final int M = 1_000_000_007;

    public static long polynomialHash(String input) {
        long hash = 0;
        long power = 1;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            hash = (hash + (c * power) % M) % M;
            power = (power * P) % M;
        }

        return hash;
    }

    public static long hashStudent(String fullName, String carnet, String courseCode, double grade) {
        String normalized = (fullName.trim() + "|" + carnet.trim() + "|" + courseCode.trim() + "|" + grade)
                .toLowerCase();
        return polynomialHash(normalized);
    }

    public static long hashGroup(long[] studentHashes) {
        StringBuilder combined = new StringBuilder();
        for (long h : studentHashes) {
            combined.append(h).append("|");
        }
        return polynomialHash(combined.toString());
    }

    public static void main(String[] args) {
        long hash1 = hashStudent("John Doe", "2023A01", "CS101", 85.5);
        long hash2 = hashStudent("Jane Smith", "2023B02", "MATH202", 90.25);

        System.out.println("Hash of Student 1: " + hash1);
        System.out.println("Hash of Student 2: " + hash2);

        long[] studentHashes = { hash1, hash2 };
        long groupHash = hashGroup(studentHashes);
        System.out.println("Group Hash: " + groupHash);
    }
}