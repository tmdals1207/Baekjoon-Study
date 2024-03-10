import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] pieces = {1, 1, 2, 2, 2, 8};
        int[] input = {0, 0, 0, 0, 0, 0};
        
        for (int i = 0; i < 6; i++) {
            input[i] = scanner.nextInt();
            System.out.print(pieces[i] - input[i] + " ");
        }
    }
}