import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int current = 1;

        int n = scanner.nextInt();
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }

        for (int num : sequence) {
            while (current <= num) {
                stack.push(current++);
                result.append("+\n");
            }

            if (stack.peek() == num) {
                stack.pop();
                result.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(result.toString());
    }
}