import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        String[] croatianAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        int count = 0;
        for (String croatianAlphabet : croatianAlphabets) {
            while (word.contains(croatianAlphabet)) {
                word = word.replaceFirst(croatianAlphabet, " ");
                count++;
            }
        }
        count += word.replaceAll("\\s", "").length();
        System.out.println(count);
    }
}
