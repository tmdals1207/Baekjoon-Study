import java.util.Scanner;

public class Main {
	
	static int N; // N static 선언

	private static int cal() {
		int cnt = N/5; // 최대한 5kg로 들고가도록 설정

		for (int i = cnt; i >= 0; i--) { // 5kg 짜리를 하나씩 빼가며 3kg로 대체
			int remainder = N - (i*5); 
			if(remainder % 3 == 0) { // 남아있던 값이 3kg로 나누어지면 종료
				return (i + (remainder / 3));
			}
		}
		
		return -1;
		
	} // cal() 종료
	
	private static boolean isPossible() {
		
		for (int i = 0; i*3 <= N; i++) {
			for (int j = 0; j*5 <= N; j++) {
				if(i*3 + j*5 == N) {
					return true;
				}
			}
		} // 2중 for문 종료
		return false;
	} // isPossible() 종료

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // N 입력받기

		N = scan.nextInt();
		
		int min = isPossible() ? cal(): -1; // 삼항연산자로 계산

		System.out.println(min);
		
		scan.close();
	} // main

} // class