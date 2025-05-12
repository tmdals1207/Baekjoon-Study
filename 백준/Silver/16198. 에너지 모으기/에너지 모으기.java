import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer> numList;
    static int max = Integer.MIN_VALUE;


    static void dfs(int length, int sum) {

        if (length == 2) {
            max = Math.max(max, sum);
        }
        
        for (int i = 1; i < length-1; i++) {
            int energy = numList.get(i-1) * numList.get(i+1);
            int tmp = numList.remove(i);
            
            dfs(length - 1, sum + energy);
            numList.add(i, tmp);
        }
    }
    

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }
        
        dfs(N, 0);
        System.out.println(max);
    }
}