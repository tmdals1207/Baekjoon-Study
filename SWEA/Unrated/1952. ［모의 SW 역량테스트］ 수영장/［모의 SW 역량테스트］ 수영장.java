import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int ONE_DAY, ONE_MONTH, THREE_MONTHS, ONE_YEAR;
    static int[] plans;

    static int answer() {
        int[] dp = new int[13];
        dp[0] = 0;

        for (int i = 1; i < plans.length; i++) {
            int monthCost = Math.min(plans[i] * ONE_DAY, ONE_MONTH);
            dp[i] = dp[i - 1] + monthCost;

            int prev = (i - 3 >= 0) ? dp[i - 3] : 0;
            dp[i] = Math.min(dp[i], prev + THREE_MONTHS);
        }
        return Math.min(dp[12], ONE_YEAR);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testcase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            ONE_DAY = Integer.parseInt(st.nextToken());
            ONE_MONTH = Integer.parseInt(st.nextToken());
            THREE_MONTHS = Integer.parseInt(st.nextToken());
            ONE_YEAR = Integer.parseInt(st.nextToken());
            plans = new int[13];

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= 12; i++) {
                plans[i] = Integer.parseInt(st.nextToken());
            }

            sb.append('#').append(tc).append(' ').append(answer()).append('\n');
        }

        System.out.println(sb);
    }
}
