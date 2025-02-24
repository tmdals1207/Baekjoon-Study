import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int arr[];
	static int[] dp;

	static void stair() {
		dp = new int[N+1];
		
		dp[1] = arr[1];
		if(N>=2) dp[2] = arr[1]+arr[2];
		if(N>=3) dp[3] = Math.max(arr[1]+arr[3], arr[2]+arr[3]);
		
		for(int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i-3]+arr[i]+arr[i-1], dp[i-2]+arr[i]);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		stair();
		
		System.out.println(dp[N]);
	}
}