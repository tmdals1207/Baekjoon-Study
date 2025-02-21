import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] parent;
	
	public static int find(int x) {
	    if (parent[x] == x) return x;
	    return parent[x] = find(parent[x]);
	}
	
	public static boolean union(int a, int b) {
	    int rootA = find(a);
	    int rootB = find(b);

	    if (rootA == rootB) return false;
	    
	    parent[rootB] = rootA;
	    return true;
	}

	public static void main(String[] args) throws IOException {
		List<Edge> edges = new ArrayList<>();
		List<Edge> mst = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			Edge edge = new Edge(u, v, w);
			edges.add(edge);
		}

		Collections.sort(edges);
		
		int totalWeight = 0;
		int edgeCount = 0;

		for (int i = 1; i <= N; i++) parent[i] = i;

		for (Edge edge : edges) {
		    if (union(edge.u, edge.v)) {
		        mst.add(edge);
		        totalWeight += edge.weight;
		        edgeCount++;

		        if (edgeCount == N - 1) break;
		    }
		}
		
		System.out.println(totalWeight);
	}
	
	public static class Edge implements Comparable<Edge> {
		
		int u, v, weight;
		
		public Edge (int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}

}