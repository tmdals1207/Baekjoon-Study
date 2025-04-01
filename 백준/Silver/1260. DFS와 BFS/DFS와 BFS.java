import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static BufferedWriter bw;

    static void dfs(int v) throws IOException {
        visited[v] = true;
        bw.write(v + " ");

        for (int w : graph.get(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
    }

    static void bfs(int v) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            bw.write(cur + " ");

            for (int w : graph.get(cur)) {
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);
        bw.newLine();

        Arrays.fill(visited, false);
        bfs(V);
        bw.newLine();

        bw.flush();
        bw.close();
    }
}