import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, S, E;
	static int[] numbers;
	static boolean[][] dp;

	
	static void palindrome() {
		
		dp = new boolean[N+1][N+1];
		
		// 길이 1인 경우 (모든 숫자는 자기 자신만으로 팰린드롬)
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }

        // 길이 2인 경우 (연속된 두 수가 같으면 팰린드롬)
        for (int i = 1; i < N; i++) {
        	dp[i][i+1] = numbers[i]==numbers[i+1] ? true : false;
        }
		
		// 길이 3이상인 경우 
		for (int len = 3; len <= N; len++) {
			for (int i = 1; i + len -1 <= N; i++) {
				int j = i + len - 1;
				if (numbers[i] == numbers[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
			}
			
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st;
        
		N = Integer.parseInt(br.readLine());
		numbers = new int[N+1];

		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i < N+1; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		
		palindrome();
		
		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			sb.append(dp[S][E] ? "1\n" : "0\n");
		}
		System.out.print(sb);
	}
}