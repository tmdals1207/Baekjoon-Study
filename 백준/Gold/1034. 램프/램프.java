import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static String[] table;
    static Map<String, Integer> pattern = new HashMap<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        table = new String[N];

        for (int i = 0; i < N; i++) {
            table[i] = br.readLine();
        }

        K = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            String row = table[i];
            int zeroCount = 0;
            for (char c : row.toCharArray()) {
                if (c == '0') zeroCount++;
            }

            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                pattern.put(row, pattern.getOrDefault(row, 0) + 1);
                answer = Math.max(answer, pattern.get(row));
            }
        }
        System.out.println(answer);
    }
}