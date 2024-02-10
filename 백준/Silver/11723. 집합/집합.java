import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        List<Integer> allNumbers = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            allNumbers.add(i);
        }

        while (x > 0) {
            String[] input = br.readLine().split(" ");
            String order = input[0];
            int num = 0;

            switch (order) {
                case "add":
                    list.add(Integer.parseInt(input[1]));
                    break;

                case "remove":
                    num = Integer.parseInt(input[1]);
                    list.remove((Integer) num);
                    break;

                case "check":
                    num = Integer.parseInt(input[1]);
                    bw.write((list.contains(num) ? "1" : "0") + "\n");
                    break;

                case "toggle":
                    num = Integer.parseInt(input[1]);
                    if (list.contains(num)) {
                        list.remove((Integer) num);
                    } else {
                        list.add(num);
                    }
                    break;

                case "all":
                    list.clear();
                    list.addAll(allNumbers);
                    break;

                case "empty":
                    list.clear();
                    break;
            }

            x--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}