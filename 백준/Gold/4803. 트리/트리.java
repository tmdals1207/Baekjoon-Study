import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	static boolean[] isCycle;

	
	public static int find(int x) {
	    if (parent[x] == x) return x;
	    return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b) {
	    int rootA = find(a);
	    int rootB = find(b);

	    if (rootA == rootB) 
	    	isCycle[rootA] = true;
	    
	    else {
	    	if(rootA < rootB) {
	    		parent[rootB] = rootA;
	    		if (isCycle[rootB]) isCycle[rootA] = true;
	    	}
	    	else {
	    		parent[rootA] = rootB;
	    		if (isCycle[rootA]) isCycle[rootB] = true;
	    	}
	    }
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder ();
		int caseNum = 1;
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if (n==0 && m==0) break;
			
			parent = new int[n+1];
			isCycle = new boolean[n+1];
			
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				union(u, v);
			}
			
			int treeCnt = 0;
			for (int k = 1; k <=n; k++) {
				if(parent[k] == k && !isCycle[k]) {
					treeCnt++;
				}
			}
			
			if (treeCnt == 0) {
                sb.append("Case ").append(caseNum).append(": No trees.\n");
            } else if (treeCnt == 1) {
                sb.append("Case ").append(caseNum).append(": There is one tree.\n");
            } else {
                sb.append("Case ").append(caseNum).append(": A forest of ").append(treeCnt).append(" trees.\n");
            }
			
			caseNum++;
		}
		System.out.println(sb);
	}
}