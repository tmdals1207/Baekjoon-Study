import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int zero, one;
	static int[][] dp = new int[41][2];
	
	static void fibonacci (int x) {
		dp[0][0] = 1;
		dp[0][1] = 0;
		
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for (int i = 2; i <= x; i++) {
			dp[i][0] =dp[i-2][0] + dp[i-1][0];
			dp[i][1] =dp[i-2][1] + dp[i-1][1];
		}
		
		zero = dp[x][0];
		one = dp[x][1];
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			fibonacci(Integer.parseInt(br.readLine()));
			bw.append(zero + " " + one + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}
