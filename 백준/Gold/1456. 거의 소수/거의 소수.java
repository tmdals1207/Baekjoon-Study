import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static long A, B;
	final static int Max = 10000000;
	static List<Long> primeNumbers;
	static boolean[] isPrime;
	
	static void sosu() {
		for (int i = 2; i <= Max; i++) {
            if (isPrime[i]) {
            	primeNumbers.add((long) i);
                for (int j = 2 * i; j <= Max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        
        primeNumbers = new ArrayList<>();
        
        isPrime = new boolean[Max+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        sosu();
        
        int count = 0;

        for (long prime : primeNumbers) {
            long num = prime * prime;
            
            while (num <= B) {
                if (num >= A) 
                	count++;
                if (num > B / prime) 
                	break;
                
                num *= prime;
            }
        }
        System.out.println(count);
	}
}