import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, cnt;
	static int[][] board;
	static long[][] dp;
	

	static void jump(int x, int y) {
		
		dp[0][0] = 1;
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int value = board[i][j];
				if(board[i][j]==0) break;
				if(i+value<N) dp[i+value][j] += dp[i][j];
				if(j+value<N) dp[i][j+value] += dp[i][j];
			}
		}
		System.out.println(dp[N-1][N-1]);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		dp = new long[N][N];
		
		for(int i = 0; i < N; i++) {
			st =  new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		jump(0, 0);
	}
}