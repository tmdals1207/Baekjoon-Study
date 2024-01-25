import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int total = 0;

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                stack.pop();
            } else {
                stack.push(input);
            }
        }

        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        bw.write(Integer.toString(total));

        br.close();
        bw.close();
    }
}
