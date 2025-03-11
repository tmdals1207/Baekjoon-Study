import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N = 0, min = Integer.MAX_VALUE;
	static int[] arr, answer;
	
	
	static void liquid() {
		int left = 0;
		int right = N-1;
		
		if (N==2) {
			answer[0] = left;
			answer[1] = right;
			return;
		}

		
		while(left<right) {
			int sum = arr[left] + arr[right];
			
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				answer[0] = left;
				answer[1] = right;
			}

			if (min == 0) break;
			
			if(sum>0) {
				right--;
			}
			else {
				left++;
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		answer = new int[2];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
				
		liquid();
		
		System.out.print(arr[answer[0]] + " " + arr[answer[1]]);
	}

}