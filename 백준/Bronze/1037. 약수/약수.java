import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] divisors = new int[N];

        for (int i = 0; i < N; i++) {
            divisors[i] = sc.nextInt();
        }
        
        Arrays.sort(divisors);
        
        int smallestInteger = divisors[0] * divisors[N - 1];
        
        System.out.println(smallestInteger);
        
        sc.close();
    }
}