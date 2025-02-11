import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int board[][];
	static int min = Integer.MAX_VALUE;
	static boolean[] selected;
	
	public static void dfs(int idx, int cnt) {
		
		if (cnt >= 1 && cnt < N) {
			calc();
		}
		
		if (idx == N) return;
		
		selected[idx] = true;
		
		dfs(idx+1, cnt+1);
		
		selected[idx] = false;
		
		dfs(idx+1, cnt);
		
	}
	
	static void calc() {
        int startSum = 0, linkSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (selected[i] && selected[j]) {
                    startSum += board[i][j];
                } else if (!selected[i] && !selected[j]) {
                    linkSum += board[i][j];
                }
            }
        }

        min = Math.min(min, Math.abs(startSum - linkSum));
    }

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		selected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		
		System.out.println(min);
	}
}