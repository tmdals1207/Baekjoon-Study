import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int white;
	static int blue;
	
	private static int cal(int startX, int startY, int size) {
		int color = board[startX][startY];
		
		for(int i = startX; i < startX+size; i++) {
			for(int j = startY; j < startY+size; j++) {
				if(board[i][j] != color) {
					return -1;
				}
			}
		}
		return color;
	}
	
	private static void divideAndConquer(int startX, int startY, int size) {
		
		if (cal(startX, startY, size) == 0) {
			white++;
			return;
		}
		else if (cal(startX, startY, size) == 1) {
			blue++;
			return;
		}
		
		int newSize = size/2;
		
		divideAndConquer(startX, startY, newSize);
		divideAndConquer(startX+newSize, startY, newSize);
		divideAndConquer(startX, startY+newSize, newSize);
		divideAndConquer(startX+newSize, startY+newSize, newSize);
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int  j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divideAndConquer(0, 0, N);

		System.out.println(white);
        System.out.println(blue);
    }
}