import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        Pair[] A = new Pair[N];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = new Pair(scanner.nextInt(), i);
        }

        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            result[A[i].index] = i;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }

        scanner.close();
    }

    static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
