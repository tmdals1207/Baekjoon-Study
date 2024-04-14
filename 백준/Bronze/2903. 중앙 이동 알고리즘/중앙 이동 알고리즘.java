import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int result = (int) Math.pow(2, n) + 1;
        result *= result;
        
        System.out.println(result);
    }
}