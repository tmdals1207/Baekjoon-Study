import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] opinions = new int[n];

        for (int i = 0; i < n; i++) {
            opinions[i] = Integer.parseInt(br.readLine());
        }

        if (n == 0) {
            bw.write("0\n");
            bw.flush();
            return;
        }

        Arrays.sort(opinions);

        int trimSize = (int) Math.round(n * 0.15);
        int sum = 0;

        for (int i = trimSize; i < n - trimSize; i++) {
            sum += opinions[i];
        }

        int result = (sum + (n - 2 * trimSize) / 2) / (n - 2 * trimSize);
        bw.write(result + "\n");
        bw.flush();
    }
}
