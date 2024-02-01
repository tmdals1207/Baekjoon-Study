import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        int result = find(cards, n, m);
        System.out.println(result);
    }

    public static int find(int[] cards, int n, int m) {
        int maxSum = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int currentSum = cards[i] + cards[j] + cards[k];

                    if (currentSum <= m && currentSum > maxSum) {
                        maxSum = currentSum;
                    }
                }
            }
        }

        return maxSum;
    }
}