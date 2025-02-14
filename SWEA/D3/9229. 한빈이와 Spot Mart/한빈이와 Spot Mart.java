import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int M;
	static int[] weight;
	static boolean check;
	static int max;
	
	static void dfs(int idx, int sum, int cnt) {
		if (sum>M) return;
		
		if(max==M) return;
		
		if(cnt ==2) {
			max = Math.max(max, sum);
			return;
		}
		if(idx == N) return;
		
		dfs(idx+1, sum+weight[idx], cnt+1);
		
		dfs(idx+1, sum, cnt);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < tc+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			weight = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				weight[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(weight);
			
			dfs(0,0,0);
			if(max == 0) {
				System.out.println("#" + i + " " + -1);
			}
			else {
				System.out.println("#" + i + " " + max);
			}
			max=0;
		}
		
	}

}
