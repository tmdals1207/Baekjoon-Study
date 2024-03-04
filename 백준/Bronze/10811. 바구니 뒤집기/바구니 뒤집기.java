import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] baskets = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            baskets[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            
            int[] temp = new int[end - start + 1];
            int idx = 0;
            
            for (int j = end; j >= start; j--) {
                temp[idx++] = baskets[j];
            }
            idx = 0;
            for (int j = start; j <= end; j++) {
                baskets[j] = temp[idx++];
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(baskets[i] + " ");
        }
    }
}