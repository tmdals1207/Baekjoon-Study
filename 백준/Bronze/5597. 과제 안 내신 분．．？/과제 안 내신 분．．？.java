import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] present = new int[31];

        for (int i = 0; i < 28; i++) {
            int studentNumber = scanner.nextInt();
            present[studentNumber] = 1;
        }

        for (int i = 1; i <= 30; i++) {
            if (present[i] == 0) {
                System.out.println(i);
            }
        }
    }
}