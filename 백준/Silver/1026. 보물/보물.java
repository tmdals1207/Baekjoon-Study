import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < n / 2; i++) {
            int temp = b[i];
            b[i] = b[n - i - 1];
            b[n - i - 1] = temp;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += a[i] * b[i];
        }

        System.out.println(result);
        sc.close();
    }
}
