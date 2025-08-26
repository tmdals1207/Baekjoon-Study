import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int N, M;
    static List<Integer>[] knowList ;
    static boolean[] visited;

    static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : knowList[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            knowList =  new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                knowList[i] = new ArrayList<>();
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                knowList[a].add(b);
                knowList[b].add(a);
            }

            visited = new boolean[N + 1];
            int groups = 0;

            for (int k = 1; k <=N; k++) {
                if (!visited[k]) {
                    bfs(k);
                    groups++;
                }
            }
            
            sb.append('#').append(t).append(' ').append(groups).append('\n');
        }

        System.out.println(sb);
    }
}
