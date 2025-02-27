import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int[] cumulative;
	static BufferedWriter bw;
	
	static void sum(int start, int end) throws IOException {
		int sum = cumulative[end] - cumulative[start-1];

		bw.write(sum + "\n");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		cumulative = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			cumulative[i] = Integer.parseInt(st.nextToken()) + cumulative[i-1]; 
		}
		
		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			sum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		bw.close();
	}
}