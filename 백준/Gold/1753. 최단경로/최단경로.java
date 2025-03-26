import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int V, E, K;
	static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    
    static void dijkstr() {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.offer(new Node(K, 0));
    	dist[K] = 0;
    	
    	while (!pq.isEmpty()) {
    		Node current = pq.poll();
            int curVertex = current.vertex;
            int curCost = current.cost;
            
            if (curCost > dist[curVertex]) continue;
            
            for (Node neighbor : graph.get(curVertex)) {
            	int nextVertex = neighbor.vertex;
                int newCost = curCost + neighbor.cost;
                
                if (newCost < dist[nextVertex]) {
                	dist[nextVertex] = newCost;
                	pq.offer(new Node(nextVertex, newCost));
                }
            }
    	}
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        
        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());
        
        for (int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	graph.get(u).add(new Node(v,w));
        }
        
        dijkstr();
        
        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
	}

}

class Node implements Comparable<Node> {
    int vertex, cost;

    Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}