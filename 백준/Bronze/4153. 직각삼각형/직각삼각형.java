import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int[] sides = new int[3];
            for (int i = 0; i < 3; i++) {
                sides[i] = scanner.nextInt();
            }

            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0) {
                break;
            }

            Arrays.sort(sides);

            if (isRightTriangle(sides)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }

    public static boolean isRightTriangle(int[] sides) {
        return sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2];
    }
}
