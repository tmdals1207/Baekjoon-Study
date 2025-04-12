import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++){
            System.out.println(sum(Integer.parseInt(br.readLine())));
        }
    }

    public static int sum(int x){
        if (x == 0 || x == 1)
            return 1;
        else if (x == 2)
            return 2;
        else if (x == 3)
            return 4;
        else
            return sum(x - 1) + sum(x - 2) + sum(x - 3);
    }
}