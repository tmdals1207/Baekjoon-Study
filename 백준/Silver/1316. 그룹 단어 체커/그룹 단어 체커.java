import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        String[] strs = new String[num];

        for (int i = 0; i < num; i++) {
            strs[i] = scanner.next();
        }

        for (String str : strs) {
            if (isGroupWord(str)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isGroupWord(String word) {
        String[] words = word.split("");
        int length = words.length;

        for (int i = 0; i < length - 1; i++) {
            char ch = word.charAt(i);
            if (words[i + 1].equals(String.valueOf(ch))) {
                continue;
            } else {
                ch = word.charAt(i + 1);

                for (int j = 0; j < i + 1; j++) {
                    if (words[j].equals(String.valueOf(ch))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}