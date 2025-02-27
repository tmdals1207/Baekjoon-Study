import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int M,N;

	static boolean sosu(int num) {
		if (num==1) return false;
		
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num%i==0) return false;
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		for (int i = M; i <= N; i++) {
			if(sosu(i)) {
				bw.write(i + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}