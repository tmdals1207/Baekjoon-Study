import java.util.Scanner;

public class Main {

	static int dwarf[], list[];
	
	static void comb(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int num : list) {
				sum += num;
			}
			if (sum == 100) {
				for (int num : list) {
					if (num == 0) break;
					System.out.println(num);
				}			
			}
			return;
		}
		for (int i = start; i<9; i++) {
			list[cnt] = dwarf[i];
			comb(cnt+1, i+1);
		}
	}


	public static void main(String args[]) throws Exception{
		Scanner sc=new Scanner(System.in);
		
		dwarf = new int[9];
		list = new int[9];
		
		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
		}
		
		comb(0,0);	
		
		sc.close();
	}

}