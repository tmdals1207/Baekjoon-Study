import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] triangle, dp;
	static int N;

	
	static void dp() {
		dp = new int[N][N];
		
		dp[0][0] = triangle[0][0];
		
		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i-1][0] + triangle[i][0];
			dp[i][i] = dp[i-1][i-1] + triangle[i][i];
			for (int j = 1; j < i; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		N = Integer.parseInt(br.readLine());
		triangle = new int[N][N];
		
		for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		dp();
		
		int max = 0;
		
		for (int m : dp[N-1]) {
			max = Math.max(max, m);
		}
		
		System.out.println(max);
	}
}