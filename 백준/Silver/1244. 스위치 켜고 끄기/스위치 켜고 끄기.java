import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int switchCnt = Integer.parseInt(br.readLine());
		
		arr = new int[switchCnt];
        arr[0] = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < switchCnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        
        }
        int studentCnt = Integer.parseInt(br.readLine());
        
        for (int j = 0; j < studentCnt; j++) {
        	st = new StringTokenizer(br.readLine());
        	int sex = Integer.parseInt(st.nextToken());
        	int number = Integer.parseInt(st.nextToken())-1;
        	if (sex == 1) {
        		maleSwith(number, arr);
        	}
        	else {
        		femaleSwith(number, arr);
        	}
        	
        }
        for (int k = 0; k < arr.length; k++) {
        	System.out.print(arr[k] + " ");
            if ((k + 1) % 20 == 0) {
                System.out.println();
            }
		}
		
	}

	private static void maleSwith(int num, int[]arr) {
		for (int i = num; i < arr.length; i += (num + 1)) {
            change(i);
        }
	}
	
	private static void femaleSwith(int num, int[]arr) {
		change(num);
        int l = num - 1;
        int r = num + 1;

        while (l >= 0 && r < arr.length && arr[l] == arr[r]) {
            change(l);
            change(r);
            l--;
            r++;
        }
	}
	private static void change(int num) {
		arr[num] = arr[num] == 1 ? 0 : 1;
	}

}