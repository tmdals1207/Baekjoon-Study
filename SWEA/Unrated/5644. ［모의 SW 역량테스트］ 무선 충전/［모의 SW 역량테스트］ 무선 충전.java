import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int M, A;
    static int[] u1, u2;
    static BC[] bcs;
    static int total;

    static int ax, ay;
    static int bx, by;

    static final int[] dx = {0, 0, 1, 0, -1};
    static final int[] dy = {0, -1, 0, 1, 0};

    static void move(int t) {
        ax += dx[u1[t]];
        ay += dy[u1[t]];

        bx += dx[u2[t]];
        by += dy[u2[t]];
    }

    static int calculate() {
        int max = 0;

        for (int i = 0; i <= A; i++) {
            int aP = 0;
            if (i != 0) {
                BC abi = bcs[i - 1];
                if (Math.abs(ax - abi.x) + Math.abs(ay - abi.y) <= abi.c) {
                    aP = abi.p;
                } else {
                    continue;
                }
            }

            for (int j = 0; j <= A; j++) {
                int bP = 0;
                if (j != 0) {
                    BC bbj = bcs[j - 1];
                    if (Math.abs(bx - bbj.x) + Math.abs(by - bbj.y) <= bbj.c) {
                        bP = bbj.p;
                    } else {
                        continue;
                    }
                }

                int gain = (i != 0 && i == j) ? aP : (aP + bP);
                if (gain > max) max = gain;
            }
        }
        return max;


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            u1 = new int[M + 1];
            u2 = new int[M + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) u1[j] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= M; k++) u2[k] = Integer.parseInt(st.nextToken());

            bcs = new BC[A];
            for (int s = 0; s < A; s++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                bcs[s] = new BC(x, y, c, p);
            }

            ax = 1; ay = 1;
            bx = 10; by = 10;
            total = 0;

            for (int t = 0; t <= M; t++) {
                total += calculate();
                if (t == M) break;
                move(t + 1);
            }
            sb.append('#').append(i + 1).append(' ').append(total).append('\n');
        }
        System.out.print(sb);
    }

    static class BC {
        int x, y, c, p;

        public BC (int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }
}
