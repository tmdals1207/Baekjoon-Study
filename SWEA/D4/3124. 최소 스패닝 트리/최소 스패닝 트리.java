import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Collections;

public class Solution {

    static int V, E, mst;
    static List<Edge> edges;
    static int[] parent, rankArr;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int a, int b) {
        int ra = find(a), rb = find(b);

        if (ra == rb){
            return false;
        }

        if (rankArr[ra] < rankArr[rb]) {
            parent[ra] = rb;
        }
        else if (rankArr[ra] > rankArr[rb]) {
            parent[rb] = ra;
        }
        else {
            parent[rb] = ra;
            rankArr[ra]++;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testcase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            edges = new ArrayList<>(E);

            for (int i = 1; i <= E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                long w = Long.parseLong(st.nextToken());
                edges.add(new Edge(u, v, w));
            }

            Collections.sort(edges);

            parent = new int[V + 1];
            rankArr = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                parent[i] = i;
            }

            long mst = 0L;
            int picked = 0;

            for (Edge e : edges) {
                if (union(e.u, e.v)) {
                    mst += e.w;
                    if (++picked == V - 1) break;
                }
            }

            sb.append('#').append(tc).append(' ').append(mst).append('\n');
        }
        System.out.println(sb);
    }

    static class Edge implements Comparable<Edge> {
        int u, v;
        long w;

        public Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Long.compare(this.w, other.w);
        }
    }
}
