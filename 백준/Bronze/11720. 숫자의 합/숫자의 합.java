import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numbers = new int[n];
        int total = 0;
        String str = sc.next();
        for(int i = 0; i < n; i++){
            numbers[i] = Character.getNumericValue(str.charAt(i));
            total += numbers[i];
        }

        System.out.println(total);
        sc.close();
    }
}