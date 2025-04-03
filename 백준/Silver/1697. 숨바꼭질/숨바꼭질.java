import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static boolean[] visited;


    static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);

        int cnt = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                int cur = queue.poll();
                visited[cur] = true;
                if (cur == K) return cnt;
                int[] list = {cur + 1, cur - 1, cur * 2};

                for (int li : list) {
                    if (li >= 0 && li <= 100000 && !visited[li]) {
                        queue.add(li);
                        visited[li] = true;
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        System.out.println(bfs());
    }
}