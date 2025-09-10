import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int N, M, K, A, B;
    static int[] recTime, repTime, arrTime;

    static int[] recCust, recEnd, repCust, repEnd;
    static int[] recDesk, repDesk;
    static ArrayDeque<Integer> recWait = new ArrayDeque<>();
    static ArrayDeque<Integer> repWait = new ArrayDeque<>();

    static int sum() {
        long s = 0;
        for (int c = 1; c <= K; c++) {
            if (recDesk[c] == A && repDesk[c] == B) s += c;
        }
        return s == 0 ? -1 : (int)s;
    }

    static boolean hasEmpty(int[] custByDesk) {
        for (int i = 1; i < custByDesk.length; i++) {
            if (custByDesk[i] == 0) return true;
        }
        return false;
    }

    static void cal() {

        recWait.clear();
        repWait.clear();

        recCust = new int[N+1]; recEnd = new int[N+1];
        repCust = new int[M+1]; repEnd = new int[M+1];
        recDesk = new int[K+1]; repDesk = new int[K+1];

        int finished = 0;
        int nextArr = 1;
        int t = 0;

        while (finished < K) {
            for (int i = 1; i <= M; i++) {
                if (repCust[i] != 0 && repEnd[i] == t) {
                    repCust[i] = 0;
                    finished++;
                }
            }

            ArrayList<int[]> finishedAtRec = new ArrayList<>();
            for (int j = 1; j <= N; j++) {
                if (recCust[j] != 0 && recEnd[j] == t) {
                    finishedAtRec.add(new int[]{j, recCust[j]});
                    recCust[j] = 0;
                }
            }

            finishedAtRec.sort((a, b) -> Integer.compare(a[0], b[0]));
            for (int[] e : finishedAtRec) repWait.offer(e[1]);

            while (nextArr <= K && arrTime[nextArr] == t) {
                recWait.offer(nextArr++);
            }

            for (int i = 1; i <= N && !recWait.isEmpty(); i++) {
                if (recCust[i] == 0) {
                    int c = recWait.poll();
                    recCust[i] = c;
                    recEnd[i] = t + recTime[i];
                    recDesk[c] = i;
                }
            }

            for (int j = 1; j <= M && !repWait.isEmpty(); j++) {
                if (repCust[j] == 0) {
                    int c = repWait.poll();
                    repCust[j] = c;
                    repEnd[j] = t + repTime[j];
                    repDesk[c] = j;
                }
            }

            if (finished >= K) break;

            int nextT = Integer.MAX_VALUE;

            if (nextArr <= K) nextT = Math.min(nextT, arrTime[nextArr]);

            for (int i = 1; i <= N; i++) {
                if (recCust[i] != 0) nextT = Math.min(nextT, recEnd[i]);
            }

            for (int j = 1; j <= M; j++) {
                if (repCust[j] != 0) nextT = Math.min(nextT, repEnd[j]);
            }

            boolean canJump =
                    (!recWait.isEmpty() && hasEmpty(recCust)) ||
                            (!repWait.isEmpty() && hasEmpty(repCust));

            if (canJump) {
                t++;
            } else {
                t = nextT;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testcase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            recTime = new int[N+1];
            repTime = new int[M+1];
            arrTime = new int[K+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                recTime[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                repTime[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= K; k++) {
                arrTime[k] = Integer.parseInt(st.nextToken());
            }

            cal();

            sb.append('#').append(tc).append(' ').append(sum()).append('\n');
        }
        System.out.println(sb);
    }
}
