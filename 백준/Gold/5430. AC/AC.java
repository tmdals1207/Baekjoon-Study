import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();

            boolean isError = false;
            boolean isReverse = false;

            String orderInput = br.readLine();
            char[] order = orderInput.toCharArray();

            int num = Integer.parseInt(br.readLine());

            String numberInput = br.readLine();
            String[] nums = numberInput.substring(1, numberInput.length() - 1).split(",");

            Deque<Integer> numbers = new ArrayDeque<>();
            if (!Objects.equals(nums[0], "")) {
                for (String s : nums) {
                    numbers.add(Integer.parseInt(s));
                }
            }

            for (char c : order) {
                if (c == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (numbers.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (!isReverse) {
                        numbers.pollFirst();
                    } else {
                        numbers.pollLast();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                sb.append("[");
                while (!numbers.isEmpty()) {
                    sb.append(isReverse ? numbers.pollLast() : numbers.pollFirst());
                    if (!numbers.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}