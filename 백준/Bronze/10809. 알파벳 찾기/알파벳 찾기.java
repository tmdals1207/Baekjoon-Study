import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        int[] alphabet = new int[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }

        s = s.trim();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (alphabet[idx] == -1) {
                alphabet[idx] = i;
            }
        }

        for (int pos : alphabet) {
            System.out.print(pos + " ");
        }
    }
}