import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int s = scanner.nextInt();

        for (int i = 0; i < n && s > 0; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n && j - i <= s; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            for (int j = maxIndex; j > i; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                s--;
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}