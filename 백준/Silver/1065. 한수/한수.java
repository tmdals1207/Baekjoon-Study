import java.util.Scanner;

public class Main {
	
	// 한수의 조건
	// 1. 각 자리의 숫자가 모두 같을 때.
	// 2. 각 자리의 숫자가 동일한 차이로 증가할 떄.
	// 3. 각 자리의 숫자가 동일한 차이로 감소할 떄.
	// 2번과 3번을 묶어서 동일한 차이일 때의 절댓값 게산으로 변경.
	
	static int N;
	static int cnt; // 출력값의 static 선언.

	private static void ap() {
		if (N == 1000) { // 1000이 한수가 아니니 편의상 999로 변환.
			N = 999;
		}
		
		int arr[] = new int[3];
		
		for (int i = 100; i <= N; i++) {
			
			arr[0] = i/100; // N의 100의 자리.
			arr[1] = (i%100)/10; // N의 10의 자리.
			arr[2] = i%10; // N의 1의 자리.
			
			if (arr[2]-arr[1] == arr[1]-arr[0]) { // 각 자리의 수들을 비교하는 식
				cnt++;
			}
		}
		
	} // ap() 종료
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		
		if (N < 100) { // 100 이하의 수는 모두 한수 이므로 그냥 출력.
			System.out.println(N);
		}
		else {
			cnt = 99; // 100부터 계산하기 위해 cnt에 99 입력.
			ap();
			System.out.println(cnt);
		}
		scan.close();
	} // main

}// class