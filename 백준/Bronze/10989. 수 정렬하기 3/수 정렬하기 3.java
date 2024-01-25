import java.io.*;
import java.util.*;

public class Main { 

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int x = Integer.parseInt(br.readLine());
		
		int[] array = new int[x];		
		
		for(int i = 0 ; i < x ; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		
		for(int A : array) {
			bw.write(Integer.toString(A));
            bw.newLine();
		}
    
        bw.flush();
        bw.close();
	}
}