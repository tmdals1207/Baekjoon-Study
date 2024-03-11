import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        
        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            int remainder = n % b;
            if (remainder < 10) {
                answer.insert(0, remainder);
            } else {
                answer.insert(0, (char) (remainder - 10 + 'A'));
            }
            n /= b;
        }

        System.out.println(answer);
    }
}