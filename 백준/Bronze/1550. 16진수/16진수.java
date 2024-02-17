import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String str = scanner.nextLine();
        int num = Integer.parseInt(str, 16);
        System.out.println(num);
    }
}