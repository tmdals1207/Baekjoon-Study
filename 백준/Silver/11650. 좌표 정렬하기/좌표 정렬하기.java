import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순으로.
		Arrays.sort(arr, (o1, o2) -> 
			o1[0] != o2[0] ? o1[0]-o2[0] : o1[1]-o2[1]);
		
		for (int j = 0; j < N; j++) {
			bw.write(arr[j][0] + " " + arr[j][1] + "\n");
		}
		
		bw.flush();
		bw.close();
		
	} // main

} // class