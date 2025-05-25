import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] dolls;
    static List<Integer> lion;


    static void cal() {
        if (lion.size() < K) {
            System.out.println(-1);
            return;
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= lion.size() - K; i++) {
            int start = lion.get(i);
            int end = lion.get(i + K - 1);
            answer = Math.min(answer, end - start + 1);
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dolls = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        lion = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (dolls[i] == 1) {
                lion.add(i);
            }
        }
        cal();
    }
}