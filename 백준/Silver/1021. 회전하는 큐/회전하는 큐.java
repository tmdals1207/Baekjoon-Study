import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for (int i = 1; i < N+1; i++) {
			deque.addLast(i);
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int j = 0; j < M; j++) {
			int goal = Integer.parseInt(st.nextToken());
			int idx = 0;
			
			for (int num : deque) {
				if (num == goal) break;
				idx++;
			}
			
			if (idx <= deque.size() / 2) {
				for (int i = 0; i < idx; i++) {
					deque.addLast(deque.pollFirst());
					cnt++;
				}
			} 
			else {
				for (int i = 0; i < deque.size() - idx; i++) {
					deque.addFirst(deque.pollLast());
					cnt++;
				}
			}
			deque.pollFirst();
		}
		System.out.println(cnt);
	}
}