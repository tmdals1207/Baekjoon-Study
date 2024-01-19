import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String A = scanner.next();
        String B = scanner.next();

        int answer = solve(A, B);
        System.out.println(answer);

        scanner.close();
    }

    private static int solve(String A, String B) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - A.length(); i++) {
            int overlap = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) == B.charAt(i + j)) {
                    overlap++;
                }
            }
            ans = Math.min(ans, A.length() - overlap);
        }

        return ans;
    }
}
