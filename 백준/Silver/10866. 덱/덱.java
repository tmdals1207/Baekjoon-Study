import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(reader.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < x; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String order = tokenizer.nextToken();

            switch (order) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(tokenizer.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(tokenizer.nextToken()));
                    break;
                case "pop_front":
                    writer.write(pop_front(deque) + "\n");
                    break;
                case "pop_back":
                    writer.write(pop_back(deque) + "\n");
                    break;
                case "size":
                    writer.write(size(deque) + "\n");
                    break;
                case "empty":
                    writer.write(empty(deque) + "\n");
                    break;
                case "front":
                    writer.write(front(deque) + "\n");
                    break;
                case "back":
                    writer.write(back(deque) + "\n");
                    break;
                default:
                    break;
            }
        }

        writer.flush();
        writer.close();
    }

    public static void push_front(Deque<Integer> deque, int x){
        deque.addFirst(x);
    }

    public static void push_back(Deque<Integer> deque, int x){
        deque.addLast(x);
    }

    public static int pop_front(Deque<Integer> deque){
        if(deque.size() == 0){
            return -1;
        }
        else{
            int number = deque.removeFirst();
            return number;
        }
    }

    public static int pop_back(Deque<Integer> deque){
        if(deque.size() == 0){
            return -1;
        }
        else{
            int number = deque.removeLast();
            return number;
        }
    }

    public static int size(Deque<Integer> deque){
        int size = deque.size();
        return size;
    }

    public static int empty(Deque<Integer> deque){
        if(deque.size() == 0){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static int front(Deque<Integer> deque){
        if(deque.size() == 0){
            return -1;
        }
        else{
            int number = deque.getFirst();
            return number;
        }
    }

    public static int back(Deque<Integer> deque){
        if(deque.size() == 0){
            return -1;
        }
        else{
            int number = deque.getLast();
            return number;
        }
    }
    
}