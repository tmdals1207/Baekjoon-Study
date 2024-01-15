import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int N = scanner.nextInt();

        long[] lanCables = new long[K];
        long maxLen = 0;

        for (int i = 0; i < K; i++) {
            lanCables[i] = scanner.nextLong();
            maxLen = Math.max(maxLen, lanCables[i]);
        }

        long left = 1;
        long right = maxLen;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (long cable : lanCables) {
                count += cable / mid;
            }
            if (count >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
        scanner.close();
    }
}
