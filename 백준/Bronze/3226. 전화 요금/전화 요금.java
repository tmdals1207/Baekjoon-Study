import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, sum;
    static int[] hours, minutes, times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        hours = new int[N];
        minutes = new int[N];
        times = new int[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            hours[i] = Integer.parseInt(input[0].substring(0,2));
            minutes[i] = Integer.parseInt(input[0].substring(3,5));
            times[i] = Integer.parseInt(input[1]);
        }

        for (int j = 0; j < N; j++) {
            int cal = minutes[j] + times[j];

            if (cal/60 == 0) {
                if (hours[j] >= 7 && hours[j] < 19) {
                    sum += times[j] * 10;
                }
                else {
                    sum += times[j] * 5;
                }
            }
            else {
                if (hours[j] >= 7 && hours[j] < 19) {
                    sum += (60 - minutes[j]) * 10;
                    if (hours[j] + 1 >= 7 && hours[j] + 1 < 19) {
                        sum += (cal % 60) * 10;
                    }
                    else {
                        sum += (cal % 60) * 5;
                    }
                }
                else {
                    sum += (60 - minutes[j]) * 5;
                    if (hours[j] + 1 >= 7 && hours[j] + 1 < 19) {
                        sum += (cal % 60) * 10;
                    }
                    else {
                        sum += (cal % 60) * 5;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}