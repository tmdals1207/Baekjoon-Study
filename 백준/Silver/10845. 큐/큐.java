import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();
        
        int n = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String operation = tokenizer.nextToken();

            switch (operation) {
                case "push":
                    int x = Integer.parseInt(tokenizer.nextToken());
                    queue.add(x);
                    break;

                case "pop":
                    if (!queue.isEmpty()) {
                        writer.write(String.valueOf(queue.poll()));
                    } else {
                        writer.write("-1");
                    }
                    writer.newLine();
                    break;

                case "size":
                    writer.write(String.valueOf(queue.size()));
                    writer.newLine();
                    break;

                case "empty":
                    writer.write(queue.isEmpty() ? "1" : "0");
                    writer.newLine();
                    break;

                case "front":
                    if (!queue.isEmpty()) {
                        writer.write(String.valueOf(queue.peek()));
                    } else {
                        writer.write("-1");
                    }
                    writer.newLine();
                    break;

                case "back":
                    if (!queue.isEmpty()) {
                        Queue<Integer> tempQueue = new LinkedList<>(queue);
                        int backElement = 0;
                        while (!tempQueue.isEmpty()) {
                            backElement = tempQueue.poll();
                        }
                        
                        writer.write(String.valueOf(backElement));
                        writer.newLine();
                    } else {
                        writer.write("-1");
                        writer.newLine();
                    }

                    break;

                default:
                    break;
            }
        }
        writer.flush();
        writer.close();
    }
}