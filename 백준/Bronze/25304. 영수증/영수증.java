import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int totalPrice = scanner.nextInt();
        int n = scanner.nextInt();
        
        int calculatedPrice = 0;
        
        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt();
            int count = scanner.nextInt();
            calculatedPrice += price * count;
        }
        
        if (totalPrice == calculatedPrice) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}