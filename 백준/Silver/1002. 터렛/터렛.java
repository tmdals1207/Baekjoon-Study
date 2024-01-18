import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int r1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int r2 = scanner.nextInt();

            int result = countIntersectionPoints(x1, y1, r1, x2, y2, r2);
            System.out.println(result);
        }

        scanner.close();
    }

    private static int countIntersectionPoints(int x1, int y1, int r1, int x2, int y2, int r2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }
        if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) {
            return 1;
        }
        if (distance < r1 + r2 && distance > Math.abs(r1 - r2)) {
            return 2;
        }
        return 0;
    }
}