import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N;
	static int[][] zoo;

	
	static void insertLions() {
		long[] dp = new long[N];
		
		dp[0] = 3;
		
		if(N==1) {
			System.out.println(dp[0]);
			return;
		}
		dp[1] = 7;
		
		for (int i = 2; i < N; i++) {
			dp[i] = ((dp[i-1] * 2) + dp[i-2])%9901;
		}
		
		System.out.println(dp[N-1]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		zoo = new int[N][2];
		
		insertLions();
	}

}