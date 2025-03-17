import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, PR, PC, maxCnt;
	static char maxDir;
	static boolean isInfinite;
	static char[][] grid;
	static char[] direction = {'U', 'R', 'D', 'L'};


	private static void voyager(char dir) {
		char curDir = dir;
		int cur_row = PR-1;
		int cur_col = PC-1;
		int cnt = 0;
		
		while(true) {
			
			cnt++;
			
			if (curDir=='U') cur_row--;
			else if (curDir=='R') cur_col++;
			else if (curDir=='D') cur_row++;
			else if (curDir=='L') cur_col--;
			
			if (cur_row < 0 || cur_row >= N || cur_col < 0 || cur_col >= M || grid[cur_row][cur_col] == 'C') {
				if (maxCnt < cnt) {
					maxCnt = cnt;
					maxDir = dir;
				}
				return;
			}
			
			if (curDir == dir && cur_row == PR-1 && cur_col == PC-1) {
				maxDir = dir;
				isInfinite = true;
				return;
			}
			
			if (grid[cur_row][cur_col] == '/' || grid[cur_row][cur_col] == '\\') {
                curDir = getNewDir(curDir, grid[cur_row][cur_col]);
            }
		}
		
		
	}	
	
	static char getNewDir(char curDir, char planet) {
        if (planet == '/') {
            if (curDir == 'U') return 'R';
            if (curDir == 'R') return 'U';
            if (curDir == 'D') return 'L';
            if (curDir == 'L') return 'D';
        } else if (planet == '\\') {
            if (curDir == 'U') return 'L';
            if (curDir == 'R') return 'D';
            if (curDir == 'D') return 'R';
            if (curDir == 'L') return 'U';
        }
        return curDir;
    }


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        grid = new char[N][M];
        
        for (int i = 0; i < N; i++) {
        	String line = br.readLine();
        	for (int j = 0; j < M; j++) {
        		grid[i][j] = (char) (line.charAt(j));
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        
        PR = Integer.parseInt(st.nextToken());
        PC = Integer.parseInt(st.nextToken());
        
        for (char c : direction) {
        	voyager(c);
        	if(isInfinite) break;
        }
        
        if (isInfinite) {
        	System.out.println(maxDir);
        	System.out.println("Voyager");
        }
        else {
        	System.out.println(maxDir);
        	System.out.println(maxCnt);
        }
	}
	
}