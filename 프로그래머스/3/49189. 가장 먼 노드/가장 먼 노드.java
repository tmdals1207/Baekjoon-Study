import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        boolean[] visited = new boolean[n+1];
        
        return (bfs(1, graph, visited, n));
    }
    
    public int bfs(int start, List<List<Integer>> graph, boolean[] visited, int n) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        int[] dist = new int[n+1];
        dist[0] = 0;
        dist[1] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph.get(cur)) {
                if (!visited[nxt]) {
                    dist[nxt] = dist[cur] + 1;
                    visited[nxt] = true;
                    q.offer(nxt);
                }
            }
        }
        int maxDist = 0;
        for (int d : dist) {
            maxDist = Math.max(d, maxDist);
        }
        int answer = 0;
        for (int d : dist) {
            if (d == maxDist) {
                answer ++;
            }
        }
        return answer;
    }
}