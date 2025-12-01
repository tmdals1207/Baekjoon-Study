import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int j = 0; j < n; j++) { 
            for (int k = 0; k < n; k++) {
                int a = computers[j][k]; 
                if (a == 1) {
                    graph.get(j).add(k);
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, graph, visited);
            }
        }
        return answer;
    }
    
    public void dfs(int start, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(start);
        visited[start] = true;
        
        while (!st.isEmpty()) {
            int cur = st.pop();
            for (int nxt : graph.get(cur)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    st.push(nxt);
                }
            }
        }
    }
}