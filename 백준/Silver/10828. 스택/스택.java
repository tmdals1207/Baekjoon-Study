import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            switch (order) {
                case "push" : {
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop" : {
                    if (stack.isEmpty()) {
                        bw.write(-1 + "\n");
                        break;
                    }
                    else {
                        bw.write(stack.pop() + "\n");
                    }
                    break;
                }
                case "size" : {
                    bw.write(stack.size() + "\n");
                    break;
                }
                case "empty" : {
                    if (stack.isEmpty()) {
                        bw.write(1 + "\n");
                        break;
                    }
                    else {
                        bw.write(0 + "\n");
                    }
                    break;
                }
                case "top" : {
                    if (stack.isEmpty()) {
                        bw.write(-1 + "\n");
                        break;
                    }
                    else {
                        bw.write(stack.peek() + "\n");
                    }
                    break;
                }
            }

        }

        bw.flush();
    }
}