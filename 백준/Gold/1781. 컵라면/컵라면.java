import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, sum;
    static Problem[] problems;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();


    static void cal() {

        for (Problem p : problems) {
            pq.add(p.cupNoodle);
            if (pq.size() > p.deadLine) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        problems = new Problem[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problems[i] = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(problems);

        cal();

        System.out.println(sum);
    }


    static class Problem implements Comparable<Problem>{
        int deadLine, cupNoodle;

        public Problem (int deadLine, int cupNoodle) {
            this.deadLine = deadLine;
            this.cupNoodle = cupNoodle;
        }

        @Override
        public int compareTo(Problem o) {
            return Integer.compare(this.deadLine, o.deadLine);
        }
    }
}