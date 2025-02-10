import java.util.Scanner;
import java.util.Stack;

public class Main {
	// 조건 1. 한번에 한개만 옮김
	// 조건 2. 항상 위의 것이 아래의 것보다 작아야 함
	// 조건 3. 이동횟수는 최소가 되도록
	static int count;
	static StringBuilder sb;

	private static void hanoiTower(int K, int from, int temp, int to) {
		
		if (K == 0) return;
		
		count++;
		
		hanoiTower(K-1, from, to, temp);
		
		sb.append(from+ " " + to + "\n");
		
		hanoiTower(K-1, temp, from, to);
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		sb = new StringBuilder();
		int K = scanner.nextInt();
		
		hanoiTower(K, 1, 2, 3);
		
		System.out.println(count);
		
		System.out.println(sb.toString());
		
		scanner.close();
	}
}