import java.io.IOException;
import java.util.Scanner;

public class Main {

	static int row, col;
	static int[] di={0,0,1,1};
	static int[] dj={0,1,0,1};
	
	private static void draw(int i, int j, int cnt, int size) {
		
		if( (row<i || i+size<=row) || (col<j || j+size<=col) ) return;
		
		if(size==2){
			for(int d=0; d<4; d++){
				int ni=i+di[d];
				int nj=j+dj[d];				
				if(ni==row && nj==col) System.out.println(cnt+d);
			}
			return;
		}
		
		draw(i,			j,			cnt+(size/2*size/2*0),	size/2);
		draw(i,			j+size/2,	cnt+(size/2*size/2*1),	size/2);
		draw(i+size/2,	j,			cnt+(size/2*size/2*2),	size/2);
		draw(i+size/2,	j+size/2,	cnt+(size/2*size/2*3),	size/2);
	}
	
	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		row=sc.nextInt();
		col=sc.nextInt();

		draw(0,0,0,(int)Math.pow(2, N));
		
		sc.close();
	}

}