import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, best;
    static Node home, company;
    static Node[] customers;
    static boolean[] visited;

    static int distance(Node n1, Node n2) {
        return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
    }

    static void dfs(int depth, int cnt, Node prev) {

        if (cnt >= best) return;

        if (depth == N) {
            cnt += distance(prev, home);
            if (cnt < best) best = cnt;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int step = distance(prev, customers[i]);
                int nextCnt = cnt + step;
                if (nextCnt >= best) continue;

                visited[i] = true;
                dfs(depth + 1, nextCnt, customers[i]);
                visited[i] = false;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testcase; tc++) {
            N = Integer.parseInt(br.readLine());
            customers = new Node[N];
            visited = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int companyX = Integer.parseInt(st.nextToken());
            int companyY = Integer.parseInt(st.nextToken());
            company = new Node(companyX, companyY);

            int homeX = Integer.parseInt(st.nextToken());
            int homeY = Integer.parseInt(st.nextToken());
            home = new Node(homeX, homeY);

            for (int i = 0; i < N; i++) {
                int customerX = Integer.parseInt(st.nextToken());
                int customerY = Integer.parseInt(st.nextToken());

                customers[i] = new Node(customerX, customerY);
            }

            best = Integer.MAX_VALUE;
            
            dfs(0, 0, company);

            sb.append('#').append(tc).append(' ').append(best).append('\n');
        }
        System.out.println(sb);
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
