import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String arr[] = new String[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		// 람다식과 삼항연사자를 사용하여 sort 연산을 간단하게 표현
		Arrays.sort(arr, (s1, s2) -> s1.length() != s2.length() ? (s1.length() - s2.length()) : s1.compareTo(s2));
		
		// 중복되는 값이 있으면 continue 하여 BufferedWriter에 쓰기에서 제외
		for(int j = 0; j < N; j++) {
			if(j !=0 && arr[j-1].equals(arr[j])) {
				continue;
			}
			bw.write(arr[j] + "\n");
		}
		
		bw.flush();
		bw.close();
		
	} // main

} // class