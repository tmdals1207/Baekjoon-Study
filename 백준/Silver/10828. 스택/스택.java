import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String operation = tokenizer.nextToken();

            switch (operation) {
                case "push":
                    int x = Integer.parseInt(tokenizer.nextToken());
                    stack.push(x);
                    break;

                case "pop":
                    if (!stack.isEmpty()) {
                        writer.write(String.valueOf(stack.pop()));
                    } else {
                        writer.write("-1");
                    }
                    writer.newLine();
                    break;

                case "size":
                    writer.write(String.valueOf(stack.size()));
                    writer.newLine();
                    break;

                case "empty":
                    writer.write(stack.isEmpty() ? "1" : "0");
                    writer.newLine();
                    break;

                case "top":
                    if (!stack.isEmpty()) {
                        writer.write(String.valueOf(stack.peek()));
                    } else {
                        writer.write("-1");
                    }
                    writer.newLine();
                    break;

                default:
                    break;
            }
        }
        writer.flush();
        writer.close();
    }
}