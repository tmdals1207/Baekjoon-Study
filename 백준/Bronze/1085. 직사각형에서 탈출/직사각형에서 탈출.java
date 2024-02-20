import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();

        int minX = Math.min(x, w - x);
        int minY = Math.min(y, h - y);

        int minDistance = Math.min(minX, minY);
        System.out.println(minDistance);
    }
}