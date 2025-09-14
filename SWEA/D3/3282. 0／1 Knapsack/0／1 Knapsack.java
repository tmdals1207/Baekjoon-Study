import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int N, K;
    static ArrayList<thing> list;

    static int knapsack() {
        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            int v = list.get(i).V;
            int c = list.get(i).C;

            for (int j = K; j >= v; j--) {
                dp[j] = Math.max(dp[j], dp[j-v] + c);
            }
        }
		
        return dp[K];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testcase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list.add(new thing(v, c));
            }

            sb.append('#').append(tc).append(' ').append(knapsack()).append('\n');
        }
        
        System.out.println(sb);
    }

    static class thing {
        int V, C;

        public thing (int V, int C) {
            this.V = V;
            this.C = C;
        }
    }
}
