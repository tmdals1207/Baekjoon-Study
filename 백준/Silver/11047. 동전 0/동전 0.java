import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		int cnt = 0; // K원을 만드는데 필요한 동전 개수.
		
		// 오름차순으로 주어졌으니 정렬은 불필요.
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		for(int j = N-1; j>=0; j--) { // 가장 큰 동전의 가치부터 차례로 내려가며 계산.
			if(K/coins[j]!=0) { // 1) 동전의 가치가 K원 보다 작으면.
				cnt += K/coins[j]; // 2) cnt에 K원 나누기 해당 동전의 가치를 더함.
				K %= coins[j]; // 3) K원은 해당 동전의 가치로 나누고 난 나머지로 변경. 
			}
		}
		System.out.println(cnt);
		br.close();
	}

}