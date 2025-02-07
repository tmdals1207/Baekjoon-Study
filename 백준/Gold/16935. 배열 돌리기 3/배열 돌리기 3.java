import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	//수행할 연산의 배열
	static int [] cal;
	//열의 크기
	static int n;
	//행의 크기
	static int m;
	//연산의 수 배열
	static int [][] board;
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		n = Integer.parseInt(st.nextToken());
		
        m = Integer.parseInt(st.nextToken());
        
        //연산의 수
        int r = Integer.parseInt(st.nextToken());
        
        board = new int [n][m];
        
        //board의 배열 채우기
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j <m; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        cal = new int [r];
        st = new StringTokenizer(br.readLine());
      //수행할 연산의 배열의 배열 채우기
        for (int k = 0; k < r; k++) {
        	cal[k] = Integer.parseInt(st.nextToken());
        }
        
        for (int num : cal) {
        	switch(num) {
        	case 1 : calculation1(); break;
        	case 2 : calculation2(); break;
        	case 3 : calculation3(); break;
        	case 4 : calculation4(); break;
        	case 5 : calculation5(); break;
        	case 6 : calculation6(); break;
        	}
        }
        
        print();
        
        br.close();
	} //Main
	
	
	public static void calculation1() {
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < m; j++) {
				int tmp = board[i][j];
				board[i][j] = board[n-1-i][j];
				board[n-1-i][j] = tmp;
			}
		}
		
	} //calculation1
	
	
	public static void calculation2() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m/2; j++) {
				int tmp = board[i][j];
				board[i][j] = board[i][m-1-j];
				board[i][m-1-j] = tmp;
			}
		}
		
	} //calculation2
	
	
	public static void calculation3() {
		int[][] newBoard = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newBoard[j][n-1-i] = board[i][j];
			}
		}
		int t=m; m=n;n=t;
		board = newBoard;
	} //calculation3
	
	
	public static void calculation4() {
		int[][] newBoard = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newBoard[m-1-j][i] = board[i][j];
			}
		}
		int t=m; m=n; n=t;
		board = newBoard;
	} //calculation4
	
	
	public static void calculation5() {
		for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
            	int t=board[i][j];			    
            	board[i][j]=board[n/2+i][j];        
            	board[n/2+i][j]=board[n/2+i][m/2+j];
            	board[n/2+i][m/2+j]=board[i][m/2+j];
            	board[i][m/2+j]=t;
            }
        }
	} // calculation5
	
	public static void calculation6() {
		for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
            	int t=board[i][j];			    
            	board[i][j]=board[i][m/2+j];        
            	board[i][m/2+j]=board[n/2+i][m/2+j];
            	board[n/2+i][m/2+j]=board[n/2+i][j];
            	board[n/2+i][j]=t;
            }
        }
	} // calculation5
	
	
	public static void print() {
		for (int []i : board) {
			for (int j : i) {
				sb.append(j).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	} //print

} //Class