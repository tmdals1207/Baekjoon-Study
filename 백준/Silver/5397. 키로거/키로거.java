import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (N-- > 0) {
			String input = br.readLine();
			LinkedList<Character> list = new LinkedList<>();
			ListIterator<Character> cursor = list.listIterator();  // 커서 사용

			for (char c : input.toCharArray()) {
				switch (c) {
					case '<':  
						if (cursor.hasPrevious()) cursor.previous();
						break;
					case '>':  
						if (cursor.hasNext()) cursor.next();
						break;
					case '-':  
						if (cursor.hasPrevious()) { 
							cursor.previous();
							cursor.remove();
						} 
						break;
					default:  
						cursor.add(c);
						break;
				}
			}

			for (char c : list) {
				sb.append(c);
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}