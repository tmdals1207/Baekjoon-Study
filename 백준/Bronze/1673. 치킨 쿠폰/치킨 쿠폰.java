import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int chicken = n;
            int stamp = n;

            while (stamp >= k) {
                int free = stamp / k;
                chicken += free;
                stamp %= k;
                stamp += free;
            }

            System.out.println(chicken);
        }
    }
}