import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int S;
	static int arr[];
	static int count;
	
	public static void dfs(int idx, int sum, int cnt) {
		if (idx == N) return;
		
		sum += arr[idx];
		
		if (cnt >= 0 && sum == S) {
			count++;
			}
		
		dfs(idx+1, sum, cnt+1);
		
		dfs(idx+1, sum-arr[idx], cnt);
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,0);
		
		System.out.println(count);
	}

}