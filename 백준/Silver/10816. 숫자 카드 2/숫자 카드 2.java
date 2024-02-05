import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> cardCount = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(tokenizer.nextToken());
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        int m = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(tokenizer.nextToken());
            result.append(cardCount.getOrDefault(target, 0)).append(" ");
        }

        System.out.println(result);
    }
}