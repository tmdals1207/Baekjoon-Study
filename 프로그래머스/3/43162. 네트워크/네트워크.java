import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n];
        
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (j == k) continue;
                if (computers[j][k] == 1) {
                    graph.get(j).add(k);
                    graph.get(k).add(j);
                }
            }
        }
        
        for (int a = 0; a < n; a++) {
            if(!visited[a]) {
                dfs(a, graph, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.push(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int cur = queue.pop();
            for (int nxt : graph.get(cur)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    queue.push(nxt);
                }
            }
        }
    }
}