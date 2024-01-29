import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        Queue<Integer> queue = new LinkedList<>();

         for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        
        Queue<Integer> resultQueue = josephus(queue, k);
        
        System.out.println(queueToString(resultQueue));
    }


    private static Queue<Integer> josephus(Queue<Integer> queue, int k) {
        Queue<Integer> resultQueue = new LinkedList<>();

        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            resultQueue.add(queue.poll());
        }

        return resultQueue;
    }
    
    
    private static <T> String queueToString(Queue<T> queue) {
        StringBuilder result = new StringBuilder("<");

        boolean first = true;
        for (T item : queue) {
            if (!first) {
                result.append(", ");
            }
            result.append(item);
            first = false;
        }

        result.append(">");
        return result.toString();
    }
}