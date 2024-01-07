import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] packagePrices = new int[M];
        int[] singlePrices = new int[M];

        for (int i = 0; i < M; i++) {
            packagePrices[i] = scanner.nextInt();
            singlePrices[i] = scanner.nextInt();
        }

        Arrays.sort(packagePrices);
        Arrays.sort(singlePrices);

        int minPackagePrice = packagePrices[0];
        int minSinglePrice = singlePrices[0];

        int minCost = Math.min(
                Math.min((N / 6) * minPackagePrice + (N % 6) * minSinglePrice,
                        (N / 6 + 1) * minPackagePrice), N * minSinglePrice);

        System.out.println(minCost);
    }
}
